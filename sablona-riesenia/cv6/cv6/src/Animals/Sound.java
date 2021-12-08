package Animals;

public class Sound implements Visitor<Void> {

    @Override
    public Void visit(Cat cat) {
        System.out.println("Meow");
        return null;
    }

    @Override
    public Void visit(Dog dog) {
        System.out.println("Woof");
        return null;
    }
    
}
