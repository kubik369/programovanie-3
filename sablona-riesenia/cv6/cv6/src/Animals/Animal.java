package Animals;

public interface Animal {

    <T> T accept(Visitor<T> visitor);
}
