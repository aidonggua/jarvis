import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
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

        MyVisitor myVisitor = new MyVisitor();
        compilationUnit.accept(myVisitor, null);
    }
}

class MyVisitor extends VoidVisitorAdapter<Void> {

    @Override
    public void visit(MethodDeclaration n, Void arg) {
        super.visit(n, arg);
        if (n.getBegin()
             .isPresent()) {
            System.out.println(n.getBegin()
                                .get());
            System.out.println(n.getEnd().get());
            System.out.println(n.getAllContainedComments());
        }
    }
}
