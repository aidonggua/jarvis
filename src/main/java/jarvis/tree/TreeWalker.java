package jarvis.tree;

import java.util.ArrayList;

public class TreeWalker {

    /**
     * 根节点
     */
    private TreeNode rootTreeNode;

    /**
     * 步行中的目录
     */
    private TreeNode currentRoot;

    /**
     * 步行中的节点
     */
    private TreeNode currentNode;

    /**
     * 新节点
     *
     * @author yehao
     * @date 2019/12/27
     */
    public void newTree(Object data) {
        rootTreeNode = new TreeNode();
        rootTreeNode.setData(data);
        rootTreeNode.setTree(true);
        rootTreeNode.setSubNodeList(new ArrayList<>());
        currentRoot = rootTreeNode;
        currentNode = rootTreeNode;
    }

    /**
     * 进入当前节点
     *
     * @author yehao
     * @date 2019/12/27
     */
    public void enter() {
        currentNode.setTree(true);
        currentNode.setSubNodeList(new ArrayList<>());
        currentRoot = currentNode;
    }

    /**
     * 退出当前节点
     *
     * @author yehao
     * @date 2019/12/27
     */
    public void out() {
        currentNode = currentRoot.getParentNode();
        currentRoot = currentRoot.getParentNode();
    }

    /**
     * 创建新节点
     *
     * @author yehao
     * @date 2019/12/27
     */
    public void createNode(Object data) {
        TreeNode newTreeNode = new TreeNode();
        newTreeNode.setData(data);
        newTreeNode.setParentNode(currentRoot);
        currentNode = newTreeNode;
        currentRoot.getSubNodeList()
                   .add(currentNode);
    }

    /**
     * 获取根节点
     *
     * @author yehao
     * @date 2019/12/27
     */
    public TreeNode getRootTreeNode() {
        return rootTreeNode;
    }
}
