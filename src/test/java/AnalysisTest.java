import jarvis.analysis.ClassElementMeta;
import jarvis.analysis.ClassMeta;
import jarvis.analysis.Lexer;
import jarvis.analysis.Parser;
import jarvis.tree.TreePrinter;
import jarvis.tree.TreeWalker;
import jarvis.utils.StringUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalysisTest {

    @Test
    public void test() throws IOException {
        //# 1 读取文件内容
        File            file            = new File("/Users/yehao/workspace/git/java/jarvis/src/test/java/AnalysisTest.java");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[]          buf             = new byte[1024];
        int             length          = 0;
        //循环读取文件内容，输入流中将最多buf.length个字节的数据读入一个buf数组中,返回类型是读取到的字节数。
        //当文件读取到结尾时返回 -1,循环结束。
        StringBuilder stringBuilder = new StringBuilder();
        while ((length = fileInputStream.read(buf)) != -1) {
            stringBuilder.append(new String(buf, 0, length));
        }

        //# 1.1 分析文件
        Parser    parser    = new Parser(new Lexer().analyse(stringBuilder.toString()));
        ClassMeta classMeta = parser.analyse();

        //# 1.1.1 打印指定格式的注释
        //# 1.1.1.1 打印指定格式的注释
        for (ClassElementMeta classElementMeta : classMeta.getMethods()) {
            if (26 > classElementMeta.getLineStart() && 26 < classElementMeta.getLineEnd()) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("<pre>\n");
                int commentNum = classElementMeta.getComments()
                                                 .size();
                int        currentLevel = -1;
                TreeWalker treeWalker   = new TreeWalker();
                treeWalker.newTree(classElementMeta.getName());
                for (int i = 0; i < commentNum; i++) {
                    String comment = classElementMeta.getComments()
                                                     .get(i);
                    Pattern pattern = Pattern.compile("//( )*\\# \\d(\\.\\d+)* .*");
                    Matcher matcher = pattern.matcher(comment);
                    if (matcher.find()) {
                        int count = StringUtils.countChar(comment, '.');
                        if (currentLevel != -1) {
                            if (currentLevel < count) {
                                treeWalker.enter();
                            } else if (currentLevel > count) {
                                for (int j = currentLevel; j > count; j--) {
                                    treeWalker.out();
                                }
                            }
                        }
                        currentLevel = count;

                        String tempStr = comment.substring(3);
                        treeWalker.createNode(tempStr);
                    }
                }

                new TreePrinter().traversal(treeWalker.getRootTreeNode(), stringBuilder);
                stringBuilder.append("</pre>");
            }
        }
        //# 2 输出到控制台
        //# 2.1 输出到控制台
        //# 2.2 输出到控制台
        //# 2.2.1 输出到控制台
        //# 2.2.2 输出到控制台
        //# 2.3 输出到控制台
        System.out.println(stringBuilder.toString());
    }
}
