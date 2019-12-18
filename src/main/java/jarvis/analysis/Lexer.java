package jarvis.analysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 词法分析器
 *
 * @author yehao
 * @date 2019-12-13
 */
public class Lexer {

    private List<String> keywords = Arrays.asList("package", "import", "public", "protected", "private", "abstract", "static", "final", "void", "class", "interface", "enum", "if", "while", "for", "do", "return", "continue", "break");

    private List<Token> tokens = new ArrayList<>();

    public List<Token> analyse(String content) {
        int             position  = -1;
        int             line      = 1;
        List<Character> tempChars = new ArrayList<>();
        while (true) {
            position++;
            if (position >= content.length()) {
                return tokens;
            }

            char c = content.charAt(position);
            switch (c) {
                case '\n':
                    line++;
                    break;
                case ' ':
                    break;
                case ';':
                case '(':
                case ')':
                case '{':
                case '}':
                case '.':
                case '<':
                case '>':
                case ',':
                case '@':
                case ':':
                    tokens.add(new Token(String.valueOf(c), null, position, line));
                    break;
                case '\'':
                    tempChars.add(c);
                    while (true) {
                        position++;
                        c = content.charAt(position);
                        tempChars.add(c);
                        if (c == '\'') {// 这里要处理转义字符
                            if (content.charAt(position - 1) == '\\' && content.charAt(position - 2) != '\\') {
                                continue;
                            }
                            tokens.add(new Token(charList2String(tempChars), null, position, line));
                            tempChars.clear();
                            break;
                        }
                    }
                    break;
                case '"':
                    // 处理字符串字面量
                    tempChars.add(c);
                    while (true) {
                        position++;
                        c = content.charAt(position);
                        tempChars.add(c);
                        if (c == '"' && content.charAt(position - 1) != '\\') {// 这里要处理转义字符
                            tokens.add(new Token(charList2String(tempChars), null, position, line));
                            tempChars.clear();
                            break;
                        }
                    }
                    break;
                case '/':
                    // 处理注释
                    String commentType = null;
                    if (content.charAt(position + 1) == '/') {
                        commentType = "SingleLine";
                    } else if (content.charAt(position + 1) == '*') {
                        commentType = "Block";
                    }
                    if (commentType != null) {
                        tempChars.add(c);
                        position++;
                        tempChars.add(content.charAt(position));
                        while (true) {
                            position++;
                            c = content.charAt(position);
                            tempChars.add(c);
                            if (c == '\n') {
                                line++;
                            }
                            if (commentType.equals("SingleLine") && c == '\n') {
                                tokens.add(new Token("LineComment", charList2String(tempChars), position, line));
                                tempChars.clear();
                                break;
                            } else if (commentType.equals("Block") && c == '/' && content.charAt(position - 1) == '*') {
                                tokens.add(new Token("BlockComment", charList2String(tempChars), position, line));
                                tempChars.clear();
                                break;
                            }
                        }
                        break;
                    }
                case '+':
                    if (content.charAt(position + 1) == '+') {
                        tokens.add(new Token("++", null, position, line));
                        position++;
                        break;
                    }
                case '-':
                    if (content.charAt(position + 1) == '-') {
                        tokens.add(new Token("--", null, position, line));
                        position++;
                        break;
                    }
                case '*':
                case '!':
                case '=':
                    // 处理双重运算符
                    if (content.charAt(position + 1) == '=') {
                        tempChars.add(c);
                        tempChars.add('=');
                        tokens.add(new Token(charList2String(tempChars), null, position, line));
                        tempChars.clear();
                        position++;
                        break;
                    } else {
                        tokens.add(new Token(String.valueOf(c), null, position, line));
                    }
                    break;
                default:
                    String lex = null;
                    if ((c > '0' && c < '9')) {
                        lex = "DIGIT";
                    } else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == '_') {
                        lex = "ID";
                    }
                    if (lex != null) {
                        while (true) {
                            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c > '0' && c < '9') || c == '_' || c == '.' || c == '<' || c == '>' || c == '*' || c == '?') {
                                tempChars.add(c);
                            } else {
                                String str = charList2String(tempChars);
                                if (keywords.contains(str)) {
                                    tokens.add(new Token(charList2String(tempChars), null, position, line));
                                } else {
                                    tokens.add(new Token(lex, charList2String(tempChars), position, line));
                                }

                                tempChars.clear();

                                position--;
                                break;
                            }

                            position++;
                            c = content.charAt(position);
                        }
                    }
            }
        }
    }

    private String charList2String(List<Character> characters) {
        StringBuilder stringBuilder = new StringBuilder();
        characters.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }
}
