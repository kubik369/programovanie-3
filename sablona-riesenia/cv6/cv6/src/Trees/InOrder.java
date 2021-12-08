package Trees;

import java.util.ArrayList;
import java.util.List;

public class InOrder implements TreeNodeVisitor<List<TreeNode>>{
    private final ArrayList<TreeNode> list = new ArrayList<>();

    @Override
    public List<TreeNode> visitLeafNode(LeafNode node) {
        list.add(node);
        return list;
    }

    @Override
    public List<TreeNode> visitInternalNode(InternalNode node) {
        if (node.left != null)
            node.left.accept(this);
        list.add(node);
        if (node.right != null)
            node.right.accept(this);
        return list;
    }
}
