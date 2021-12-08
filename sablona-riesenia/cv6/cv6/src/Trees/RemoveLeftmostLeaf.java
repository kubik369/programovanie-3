package Trees;

public class RemoveLeftmostLeaf implements TreeNodeVisitor<TreeNode> {
    @Override
    public TreeNode visitLeafNode(LeafNode node) {
        return node;
    }

    @Override
    public TreeNode visitInternalNode(InternalNode node) {
        TreeNode tmp = node;
        if (node.left != null)
            tmp = node.left.accept(this);
        else if (node.right != null)
            tmp = node.right.accept(this);
        if (node.left == tmp)
            node.left = null;
        if (node.right == tmp)
            node.right = null;
        return tmp;
    }
}
