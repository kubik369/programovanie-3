package Trees;

public class RemoveLeafById implements TreeNodeVisitor<TreeNode>{
    public int id;

    public RemoveLeafById(int id) {
        this.id = id;
    }

    @Override
    public TreeNode visitLeafNode(LeafNode node) {
        if (node.getId() == id)
            return null;
        else
            return node;
    }

    @Override
    public TreeNode visitInternalNode(InternalNode node) {
        if (node.left != null)
            node.left = node.left.accept(this);
        if (node.right != null)
            node.right = node.right.accept(this);
        if (node.getId() == id) {
            if (node.left == null) {
                return node.right;
            }else if (node.right == null) {
                return node.left;
            }else {
                TreeNode tmp = node.right.accept(new RemoveLeftmostLeaf());
                if (tmp == node.right)
                    node.right = null;
                return new InternalNode(tmp.getId(), node.left, node.right);
            }
        }else {
            if (node.left == null && node.right == null)
                return new LeafNode(node.getId());
            return node;
        }
    }
}
