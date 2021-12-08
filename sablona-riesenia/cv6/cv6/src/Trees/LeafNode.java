package Trees;

public class LeafNode implements TreeNode {
    private final int id;

    public LeafNode(int id) {
        this.id = id;
    }
    @Override
    public int getId() {
        return id;
    }

    @Override
    public <T> T accept(TreeNodeVisitor<T> v) {
        return v.visitLeafNode(this);
    }
}
