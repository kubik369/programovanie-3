package Trees;

public interface TreeNode {
    int getId();
    <T> T accept(TreeNodeVisitor<T> v);
}
