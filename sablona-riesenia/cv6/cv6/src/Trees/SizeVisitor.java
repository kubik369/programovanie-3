package Trees;

public class SizeVisitor implements TreeNodeVisitor<Integer> {
    @Override
    public Integer visitLeafNode(LeafNode node) {
        return 1;
    }

    @Override
    public Integer visitInternalNode(InternalNode node) {
        int size = 1;
        if (node.getLeftChild() != null)
            size += node.getLeftChild().accept(this);
        if (node.getRightChild() != null)
            size += node.getRightChild().accept(this);
        return size;
    }
}
