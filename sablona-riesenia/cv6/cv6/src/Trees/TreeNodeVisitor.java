package Trees;

public interface TreeNodeVisitor<T>  {

    T visitLeafNode(LeafNode node);
    T visitInternalNode(InternalNode node);
}
