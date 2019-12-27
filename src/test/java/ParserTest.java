import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.visitor.ModifierVisitor;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

public class ParserTest {

    @Test
    public void test() throws FileNotFoundException {
        File            file            = new File("/Users/yehao/workspace/git/java/jarvis/src/test/java/AnalysisTest.java");
        CompilationUnit compilationUnit = StaticJavaParser.parse(file);
        //        System.out.println(compilationUnit);
        //        System.out.println(compilationUnit.getComments());
        //        System.out.println(compilationUnit.getMetaModel().getAllPropertyMetaModels());
        ModifierVisitor visitor = new ModifierVisitor();
        //        visitor.
    }
}
