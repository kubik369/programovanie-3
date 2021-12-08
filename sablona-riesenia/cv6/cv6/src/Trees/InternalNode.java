package Trees;

public class InternalNode implements TreeNode {
    TreeNode left, right;
    private final int id;

    public InternalNode(int id, TreeNode left, TreeNode right) {
        this.id = id;
        this.left = left;
        this.right = right;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public <T> T accept(TreeNodeVisitor<T> v) {
        return v.visitInternalNode(this);
    }

    public TreeNode getLeftChild() {
        return left;
    }

    public TreeNode getRightChild() {
        return right;
    }
}
