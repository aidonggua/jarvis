package jarvis.tree;

import java.util.List;

public class TreeNode {

    private Object data;

    private boolean isTree;

    private TreeNode parentNode;

    private List<TreeNode> subNodeList;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isTree() {
        return isTree;
    }

    public void setTree(boolean tree) {
        isTree = tree;
    }

    public List<TreeNode> getSubNodeList() {
        return subNodeList;
    }

    public void setSubNodeList(List<TreeNode> subNodeList) {
        this.subNodeList = subNodeList;
    }

    public TreeNode getParentNode() {
        return parentNode;
    }

    public void setParentNode(TreeNode parentNode) {
        this.parentNode = parentNode;
    }
}
