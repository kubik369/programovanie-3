import Animals.*;

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

    public static void main(String[] args) {
        animals();
    }
}
