package jarvis.analysis;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    private int position;

    private List<Token> tokens;

    private ClassMeta classMeta;

    private Token getCurrentToken() {
        return tokens.get(position);
    }

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
        position = -1;
        classMeta = new ClassMeta();
    }

    /**
     * 分析token流
     *
     * @author yehao
     * @date 2019-12-18
     */
    public ClassMeta analyse() {
        while (true) {
            position++;
            if (position >= tokens.size()) {
                return classMeta;
            }
            Token token = tokens.get(position);
            Meta  meta;
            switch (token.getLex()) {
                case "package":
                    // 解析package语句
                    meta = packageStmt();
                    classMeta.setPackageMeta(meta);
                    break;
                case "import":
                    // 解析import语句
                    meta = importStmt();
                    classMeta.getImportMeta()
                             .add(meta);
                    break;
                case "LineComment":
                case "BlockComment":
                    // 丢弃方法体外部的注释
                    break;
                case "@":
                    // 丢弃注解
                    validNext("ID");
                    if (seekNext("(", false)) {
                        popPair("(", ")");
                    }
                    break;
                default:
                    // 解析类主体
                    classStmt();
            }
        }
    }

    /**
     * 解析package语句
     *
     * @author yehao
     * @date 2019-12-18
     */
    private Meta packageStmt() {
        Meta meta = new Meta();
        meta.setLine(getCurrentToken().getLine());
        Token token = validNext("ID");
        meta.setId(token.getLex());
        validNext(";");
        return meta;
    }

    /**
     * 解析import语句
     *
     * @author yehao
     * @date 2019-12-18
     */
    private Meta importStmt() {
        Meta meta = new Meta();
        meta.setLine(getCurrentToken().getLine());
        seekNext("static");
        Token token = validNext("ID");
        meta.setId(token.getId());
        validNext(";");
        return meta;
    }

    /**
     * 解析class语句
     *
     * @author yehao
     * @date 2019-12-18
     */
    private void classStmt() {
        if (seekCurrent("public")) {
            classMeta.setVisibility(getCurrentToken().getLex());
        }

        if (seekNext("abstract")) {
            classMeta.setVisibility(getCurrentToken().getLex());
        }

        if (seekNext("class", "interface", "enum")) {
            classMeta.setClassType(getCurrentToken().getLex());
        }

        Token token = validNext("ID");
        classMeta.setClassName(token.getId());
        // 这里丢弃extends implement等语句
        popUntil("{");
        boolean isOk = seekClassElement();
        if (!isOk) {
            throw new RuntimeException("class语句解析错误");
        }
    }

    private boolean seekClassElement() {
        while (true) {
            position++;
            if (position >= tokens.size()) {
                return false;
            }

            switch (getCurrentToken().getLex()) {
                case "}":
                    return true;
                case "BlockComment":
                case "LineComment":
                    continue;
                case "@":
                    validNext("ID");
                    if (seekNext("(")) {
                        popPair("(", ")");
                    }
                    continue;
                default:
                    ClassElementMeta classElementMeta = new ClassElementMeta();
                    if (seekCurrent("public", "private", "protected")) {
                        classElementMeta.setVisibility(getCurrentToken().getLex());
                    } else {
                        position--;
                    }
                    classElementMeta.setAbstract(seekNext("abstract"));
                    classElementMeta.setStatic(seekNext("static"));
                    classElementMeta.setFinal(seekNext("final"));
                    if (seekNext("void")) {
                        classElementMeta.setType("void");
                    } else {
                        classElementMeta.setType(validNext("ID").getId());
                    }

                    if (seekNext("(")) {
                        // 构造函数
                        classElementMeta.setName(classElementMeta.getType());
                        seekFunction(classElementMeta);
                        classMeta.getMethods()
                                 .add(classElementMeta);
                        continue;
                    } else {
                        classElementMeta.setName(validNext("ID").getId());
                    }

                    if (seekNext("(")) {
                        classElementMeta.setLineStart(getCurrentToken().getLine());
                        seekFunction(classElementMeta);
                        classMeta.getMethods()
                                 .add(classElementMeta);
                    } else {
                        classMeta.getFields()
                                 .add(classElementMeta);
                        if (seekNext("=")) {
                            popUntil(";");
                        }
                        seekNext(";");
                    }
                    break;
            }
        }
    }

    /**
     * @author yehao
     * @date 2019-12-18
     */
    private void seekFunction(ClassElementMeta classElementMeta) {
        List<Token> filterTokens = filterMethodToken("LineComment");
        classElementMeta.setComments(filterTokens.stream()
                                                 .map(Token::getId)
                                                 .collect(Collectors.toList()));
        Token token = tokens.get(position);
        classElementMeta.setLineEnd(token.getLine());
    }

    /**
     * 判断当前token的lex是不是指定lex
     *
     * @author yehao
     * @date 2019-12-18
     */
    private boolean seekCurrent(String... lexs) {
        Token token = tokens.get(position);
        for (String lex : lexs) {
            if (token.getLex()
                     .equals(lex)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断下一个token是不是指定的某个lex
     *
     * @param ignoreComments 是否忽视中途的注释
     * @author yehao
     * @date 2019-12-18
     */
    private boolean seekNext(String lex, boolean ignoreComments) {
        while (true) {
            position++;
            Token  token      = tokens.get(position);
            String currentLex = token.getLex();
            if (ignoreComments && (currentLex.equals("LineComment") || currentLex.equals("BlockComment"))) {
                continue;
            }

            if (currentLex.equals(lex)) {
                return true;
            }
            position--;
            return false;
        }
    }

    /**
     * 判断下一个token是不是指定的某个lex
     *
     * @author yehao
     * @date 2019-12-18
     */
    private boolean seekNext(String... lexArray) {
        position++;
        Token token = tokens.get(position);
        for (String lex : lexArray) {
            if (token.getLex()
                     .equals(lex)) {
                return true;
            }
        }
        position--;
        return false;
    }

    /**
     * 过滤出指定的词素
     *
     * @author yehao
     * @date 2019-12-18
     */
    private List<Token> filterMethodToken(String lex) {
        List<Token> filterTokens    = new ArrayList<>();
        int         leftBracesCount = 0;
        if (getCurrentToken().getLex()
                             .equals(lex)) {
            leftBracesCount++;
        }
        while (true) {
            position++;
            Token token = getCurrentToken();
            if (token.getLex()
                     .equals("{")) {
                leftBracesCount++;
            } else if (token.getLex()
                            .equals("}")) {
                leftBracesCount--;
                if (leftBracesCount == 0) {
                    return filterTokens;
                }
            } else if (token.getLex()
                            .equals(lex)) {
                filterTokens.add(token);
            }
        }
    }

    /**
     * 校验下一个token
     *
     * @author yehao
     * @date 2019-12-18
     */
    private Token validNext(String lex) {
        position++;
        Token currentToken = getCurrentToken();
        if (!currentToken.getLex()
                         .equals(lex)) {
            throw new RuntimeException(String.format("预期[%s]失败：%s-%s-%d", lex, currentToken.getLex(), currentToken.getId(), currentToken.getLine()));
        }
        return currentToken;
    }

    /**
     * 丢弃任何token，直到碰到指定词素
     *
     * @author yehao
     * @date 2019-12-18
     */
    private void popUntil(String lex) {
        while (true) {
            position++;
            if (getCurrentToken().getLex()
                                 .equals(lex)) {
                return;
            }
        }
    }

    /**
     * 丢弃指定pair里面的任何内容
     *
     * @author yehao
     * @date 2019-12-18
     */
    private void popPair(String leftLex, String rightLex) {
        Token token           = tokens.get(position);
        int   leftParentheses = 0;
        if (token.getLex()
                 .equals(leftLex)) {
            leftParentheses++;
            while (true) {
                position++;
                token = tokens.get(position);
                if (token.getLex()
                         .equals(rightLex)) {
                    leftParentheses--;
                    if (leftParentheses == 0) {
                        return;
                    }
                }
            }
        }
    }
}
