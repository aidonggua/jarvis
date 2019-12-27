import jarvis.analysis.ClassElementMeta;
import jarvis.analysis.ClassMeta;
import jarvis.analysis.Lexer;
import jarvis.analysis.Parser;
import jarvis.tree.TreeManager;
import jarvis.tree.TreeNode;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserTest {

    @Test
    public void test() throws IOException {
        //# 1 读取文件内容
        File            file            = new File("/Users/yehao/workspace/git/java/jarvis/src/test/java/ParserTest.java");
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
                int         currentLevel = -1;
                TreeManager treeManager  = new TreeManager();
                treeManager.newTree(classElementMeta.getName());
                for (int i = 0; i < commentNum; i++) {
                    String comment = classElementMeta.getComments()
                                                     .get(i);
                    Pattern pattern = Pattern.compile("//( )*\\# \\d(\\.\\d+)* .*");
                    Matcher matcher = pattern.matcher(comment);
                    if (matcher.find()) {
                        int count = countChar(comment, '.');
                        if (currentLevel != -1) {
                            if (currentLevel < count) {
                                treeManager.enter();
                            } else if (currentLevel > count) {
                                for (int j = currentLevel; j > count; j--) {
                                    treeManager.out();
                                }
                            }
                        }
                        currentLevel = count;

                        String tempStr = comment.substring(3);
                        treeManager.createNode(tempStr);
                    }
                }

                traversal(treeManager.getRootTreeNode(), 0, stringBuilder);
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

    public int countChar(String str, char c) {
        int count = 0;
        for (char tempC : str.toCharArray()) {
            if (tempC == c) {
                count++;
            }
        }
        return count;
    }

    List<Boolean> printFlag = new ArrayList<>();

    public void traversal(TreeNode treeNode, int depth, StringBuilder stringBuilder) {
        if (printFlag.size() <= depth) {
            printFlag.add(false);
        }
        if (treeNode.getParentNode() == null) {
            stringBuilder.append(treeNode.getData());
            stringBuilder.append('\n');
        }
        int max = treeNode.getSubNodeList()
                          .size();
        for (int i = 0; i < max; i++) {
            TreeNode subTreeNode = treeNode.getSubNodeList()
                                           .get(i);
            for (int j = 0; j < depth; j++) {
                if (printFlag.get(j) != null && printFlag.get(j)) {
                    stringBuilder.append('│');
                }
                stringBuilder.append('\t');
            }
            if (i == max - 1) {
                stringBuilder.append("└──");
            } else {
                stringBuilder.append("├──");
            }
            stringBuilder.append(subTreeNode.getData());

            if (subTreeNode.isTree()) {
                printFlag.set(depth, i != max - 1);
                traversal(subTreeNode, depth + 1, stringBuilder);
            }
        }
    }
}
