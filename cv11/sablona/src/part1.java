
// staticky import
import static java.lang.Math.*;

public class part1 {

    interface Drink {
        double volume();
        double alcoholContent();

        // add later
        default double alcoholVolume() {
            return volume() * alcoholContent();
        }

        // add even more later
        static String warning() {
            return "Alkohol vazne skodi vasmu zdraviu.";
        }
    }

    private void local_class_example() {
        class Burger {
            public double mass() {
                return 0.180;
            }

            public String type() {
                return "medium-rare";
            }
        }

        class Beer implements Drink {
            @Override
            public double volume() {
                return 0.5;
            }

            @Override
            public double alcoholContent() {
                return 0.05;
            }
        }

        Burger burger = new Burger();
        Drink drink = new Beer();
    }

    private void anonymous_class_example() {
        // Steak steak = new Steak() {}; // nefunguje

        // anonymna trieda potrebuje mat preddefinovany interface
        Drink absinth = new Drink() {
            @Override
            public double volume() {
                return 0.04;
            }

            @Override
            public double alcoholContent() {
                return 0.8;
            }
        };
    }

    private void default_methods_example() {
        Drink beer = new Drink() {
            @Override
            public double volume() {
                return 0.5;
            }

            @Override
            public double alcoholContent() {
                return 0.05;
            }
        };
        System.out.println("Beer alcohol volume: " + beer.alcoholVolume());
    }

    private void static_import_example() {
        System.out.println("cos(0.0) = " + cos(0.0));
        System.out.println("cos(1) = " + cos(1));
    }

    private void static_methods_example() {
        System.out.println(Drink.warning());
    }



    public void demo() {
        local_class_example();
        anonymous_class_example();
        default_methods_example();
        static_import_example();
        static_methods_example();
    }
}
