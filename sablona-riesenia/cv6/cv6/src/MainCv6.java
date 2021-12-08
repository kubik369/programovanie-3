import Animals.*;
import Trees.*;

public class MainCv6 {

    static void animals(){
        System.out.println("========Animals=========");
        Animal dog = new Dog();
        System.out.println("dog's speed: " + dog.accept(new Speed()));
        System.out.print("dog's sound: ");
        dog.accept(new Sound());

        Animal cat = new Cat();
        System.out.println("cat's speed: " + cat.accept(new Speed()));
        System.out.print("cat's sound: ");
        cat.accept(new Sound());
    }

    static TreeNode createSimpleTree(){
        return new InternalNode(0,
                new InternalNode(1,
                        new LeafNode(11),
                        new LeafNode(12)),
                new InternalNode(2,
                        new LeafNode(21),
                        new LeafNode(22)));
    }

    static void print(TreeNode root, String message){
        System.out.print(message);
        root.accept(new PrintVisitor());
        System.out.println();
    }

    static void print(TreeNode root){
        print(root, "structure ");
    }

    static void trees(){
        System.out.println("========Trees=========");
        TreeNode root = createSimpleTree();
        System.out.println("size: " + root.accept(new SizeVisitor()));

        print(root);

        System.out.print("in-order iteration: ");
        for (TreeNode node : root.accept(new InOrder())){
            System.out.print(node.getId() + " ");
        }
        System.out.println("\nremove leftmost leaf: ");
        TreeNode leftmost = null;
        while (leftmost != root) {
            print(root, "\t");
            leftmost = root.accept(new RemoveLeftmostLeaf());
        }


        System.out.println("remove leaf by id: ");
        root = createSimpleTree();
        print(root, "\tfull tree: ");
        root.accept(new RemoveLeafById(11));
        print(root, "\t11 was removed: ");
        root.accept(new RemoveLeafById(2));
        print(root, "\t2 was removed: ");

        root = new InternalNode(100,
                    new InternalNode(120,null, null),
                    new InternalNode(200,
                            new InternalNode(300, null, null),
                            new LeafNode(0)));
        System.out.println("convert to leaves: ");
        print(root, "\tbefore: ");
        root.accept(new ConvertToLeaves());
        print(root, "\tafter: ");
    }

    public static void main(String[] args) {
        animals();
        trees();
    }
}
