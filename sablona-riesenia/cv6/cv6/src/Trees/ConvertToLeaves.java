package Trees;

import java.util.LinkedList;

public class ConvertToLeaves implements TreeNodeVisitor<Void> {
    private final LinkedList<InternalNode> stack = new LinkedList<>();

    @Override
    public Void visitLeafNode(LeafNode node) {
        return null;
    }

    @Override
    public Void visitInternalNode(InternalNode node) {
        if (node.left == null && node.right == null){
            InternalNode parent = stack.peek();
            if (parent != null) {
                if (parent.left == node)
                    parent.left = new LeafNode(node.getId());
                else
                    parent.right = new LeafNode(node.getId());
            }
            return null;
        }
        stack.push(node);
        if (node.left != null)
            node.left.accept(this);
        if (node.right != null)
            node.right.accept(this);
        stack.pop();
        return null;
    }
}
