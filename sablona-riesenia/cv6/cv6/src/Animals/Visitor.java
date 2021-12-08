package Animals;

import Animals.Cat;
import Animals.Dog;

public interface Visitor<T> {

    T visit(Cat cat);
    T visit(Dog dog);

}
