import jarvis.tree.TreeManager;
import org.junit.Test;

public class TreeManagerTest {

    @Test
    public void testTreeManager() {
        TreeManager treeManager = new TreeManager();
        treeManager.newTree("1");
        treeManager.createNode("1.1");
        treeManager.createNode("1.2");
        treeManager.enter();
        treeManager.createNode("1.2.1");
        treeManager.createNode("1.2.2");
        treeManager.out();
        treeManager.createNode("1.3");
        System.out.println(treeManager);
    }
}
