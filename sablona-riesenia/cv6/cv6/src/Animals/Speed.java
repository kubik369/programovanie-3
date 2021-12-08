package Animals;

public class Speed implements Visitor<Integer> {
    @Override
    public Integer visit(Cat cat) {
        return 48;
    }

    @Override
    public Integer visit(Dog dog) {
        return 32;
    }
}
