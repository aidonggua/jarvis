import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

public class ParserTest {

    @Test
    public void test() throws FileNotFoundException {
        File            file            = new File("/Users/yehao/workspace/git/java/jarvis/src/test/java/ParserTest.java");
        CompilationUnit compilationUnit = StaticJavaParser.parse(file);
        System.out.println(compilationUnit);
    }
}
