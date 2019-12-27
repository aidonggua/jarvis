package jarvis.tree;

import java.util.ArrayList;

public class TreeManager {

    private TreeNode rootTreeNode;

    private TreeNode currentRoot;

    private TreeNode currentNode;

    public void newTree(Object data) {
        rootTreeNode = new TreeNode();
        rootTreeNode.setData(data);
        rootTreeNode.setTree(true);
        rootTreeNode.setSubNodeList(new ArrayList<>());
        currentRoot = rootTreeNode;
        currentNode = rootTreeNode;
    }

    public void enter() {
        currentNode.setTree(true);
        currentNode.setSubNodeList(new ArrayList<>());
        currentRoot = currentNode;
    }

    public void out() {
        currentNode = currentRoot.getParentNode();
        currentRoot = currentRoot.getParentNode();
    }

    public void createNode(Object data) {
        TreeNode newTreeNode = new TreeNode();
        newTreeNode.setData(data);
        newTreeNode.setParentNode(currentRoot);
        currentNode = newTreeNode;
        currentRoot.getSubNodeList()
                   .add(currentNode);
    }

    public TreeNode getRootTreeNode() {
        return rootTreeNode;
    }

    public void setRootTreeNode(TreeNode rootTreeNode) {
        this.rootTreeNode = rootTreeNode;
    }
}
