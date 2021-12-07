import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class part3 {

    static <T> ArrayList<T> select(ArrayList<T> list, Predicate<T> p) {
        ArrayList<T> res = new ArrayList<>();
        for (T e: list) {
            if (p.test(e)) res.add(e);
        }
        return res;
    }

    private void predicates_example() {
        ArrayList<String> A = new ArrayList<>(Arrays.asList("", "", "aa", "aba", "abb",  "baa", "baabbaab"));
        System.out.println(select(A, String::isEmpty));
        System.out.println(select(A, ((Predicate<String>) String::isEmpty).negate()));

        Predicate<String> startsWithA = s -> !s.isEmpty() && s.charAt(0) == 'a';
        System.out.println(select(A, startsWithA));

        Predicate<String> endsWithB = s -> !s.isEmpty() && s.charAt(s.length()-1) == 'b';
        System.out.println(select(A, startsWithA.and(endsWithB)));
    }

    static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T e: list) {
            c.accept(e);
        }
    }

    private void consumer_example() {
        ArrayList<String> A = new ArrayList<>(Arrays.asList("", "", "aa", "aba", "abb",  "baa", "baabbaab"));

        ArrayList<String> B = new ArrayList<>();
        forEach(A, s -> B.add(s.replaceAll("a", "x")));
        B.add("q");
        System.out.println(B);
    }

    static Double mySqrt(double x) {
        if (x >= 0) return Math.sqrt(x);
        else return null;

    }

    static <I, O> ArrayList<O> apply(ArrayList<I> list, Function<I, O> f) {
        ArrayList<O> res = new ArrayList<>();
        for (I e: list) {
            res.add(f.apply(e));
        }
        return res;
    }

    private void optionals_example() {
        ArrayList<Double> A = new ArrayList<>(Arrays.asList(1.0,4.0,9.0,0.0, -10.0));
        ArrayList<Optional<Double>> B = apply(A, x -> Optional.ofNullable(mySqrt(x)));
        forEach(B, x -> x.ifPresent(System.out::println));
    }

    public void demo() {
        predicates_example();
        consumer_example();
        optionals_example();
    }
}
