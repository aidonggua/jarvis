import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.ModifierVisitor;
import com.github.javaparser.ast.visitor.Visitable;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

public class ParserTest {

    public static final int money = 900_000_000;

    /**
     * test
     *
     * @author yehao
     * @date 2020/1/9
     */
    @Test
    public void test() throws FileNotFoundException {
        File            file            = new File("/Users/yehao/workspace/git/java/jarvis/src/test/java/ParserTest.java");
        CompilationUnit compilationUnit = StaticJavaParser.parse(file);
        //        System.out.println(compilationUnit);
        //        System.out.println(compilationUnit.getComments());
        System.out.println(compilationUnit.getAllContainedComments());

        IntegerVisitor integerVisitor = new IntegerVisitor();
        compilationUnit.accept(integerVisitor, null);

        MyVisitor myVisitor = new MyVisitor();
        compilationUnit.accept(myVisitor, null);
    }
}

class MyVisitor extends VoidVisitorAdapter<Void> {

    @Override
    public void visit(MethodDeclaration n, Void arg) {
        super.visit(n, arg);
        System.out.println(n.getName());
        System.out.println(n.getAllContainedComments());
        System.out.println(n.getComment());
    }
}

class IntegerVisitor extends ModifierVisitor<Void> {

    @Override
    public Visitable visit(FieldDeclaration n, Void arg) {
        super.visit(n, arg);
        return n;
    }
}
