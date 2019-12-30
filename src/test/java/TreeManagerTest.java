
import jarvis.tree.TreeWalker;
import org.junit.Test;

public class TreeManagerTest {

    @Test
    public void testTreeManager() {
        TreeWalker treeWalker = new TreeWalker();
        treeWalker.newTree("1");
        treeWalker.createNode("1.1");
        treeWalker.createNode("1.2");
        treeWalker.enter();
        treeWalker.createNode("1.2.1");
        treeWalker.createNode("1.2.2");
        treeWalker.out();
        treeWalker.createNode("1.3");
        System.out.println(treeWalker);
    }
}
