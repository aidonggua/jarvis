package jarvis.tree;

import jarvis.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreePrinter {

    List<Boolean> printFlag = new ArrayList<>();

    public void traversal(TreeNode treeNode, StringBuilder stringBuilder) {
        traversal(treeNode, 0, stringBuilder);
    }

    public void traversal(TreeNode treeNode, int depth, StringBuilder stringBuilder) {
        if (printFlag.size() <= depth) {
            printFlag.add(false);
        }
        if (treeNode.getParentNode() == null) {
            stringBuilder.append(treeNode.getData());
            stringBuilder.append('\n');
        }
        int max = treeNode.getSubNodeList()
                          .size();
        for (int i = 0; i < max; i++) {
            TreeNode subTreeNode = treeNode.getSubNodeList()
                                           .get(i);
            for (int j = 0; j < depth; j++) {
                if (printFlag.get(j) != null && printFlag.get(j)) {
                    stringBuilder.append('│');
                }
                stringBuilder.append('\t');
            }
            if (i == max - 1) {
                stringBuilder.append("└──");
            } else {
                stringBuilder.append("├──");
            }
            stringBuilder.append(subTreeNode.getData());

            if (subTreeNode.isTree()) {
                printFlag.set(depth, i != max - 1);
                traversal(subTreeNode, depth + 1, stringBuilder);
            }
        }
    }
}
