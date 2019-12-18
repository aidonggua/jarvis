import jarvis.analysis.ClassElementMeta;
import jarvis.analysis.ClassMeta;
import jarvis.analysis.Lexer;
import jarvis.analysis.Parser;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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

        //# 2 分析文件
        Lexer.analyse(stringBuilder.toString());
        Parser    parser    = new Parser(Lexer.getTokens());
        ClassMeta classMeta = parser.analyse();

        //# 3 打印指定格式的注释
        for (ClassElementMeta classElementMeta : classMeta.getMethods()) {
            if (17 > classElementMeta.getLineStart() && 17 < classElementMeta.getLineEnd()) {
                stringBuilder = new StringBuilder();
                for (String comment : classElementMeta.getComments()) {
                    Pattern pattern = Pattern.compile("//( )*\\# \\d(\\.\\d+)* .*");
                    Matcher matcher = pattern.matcher(comment);
                    if (matcher.find()) {
                        stringBuilder.append(comment);
                    }
                }
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
