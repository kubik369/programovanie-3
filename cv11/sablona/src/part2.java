import java.util.ArrayList;
import java.util.Arrays;

public class part2 {

    @FunctionalInterface
    interface UnaryFunction<InputType, OutputType> {
        OutputType call(InputType arg);
        static void uselessStaticFunction() {
            System.out.println("I am useless function");
        }
    }

    @FunctionalInterface
    interface BinaryFunction<InputType1, InputType2, OutputType> {
        OutputType call(InputType1 arg1, InputType2 arg2);
    }

    static <T, Q> ArrayList<Q> apply(ArrayList<T> list, UnaryFunction<T, Q> f) {
        ArrayList<Q> res = new ArrayList<>();
        for (T e: list) {
            res.add(f.call(e));
        }
        return res;
    }

    static <T> ArrayList<T> select(ArrayList<T> list, UnaryFunction<T, Boolean> f) {
        ArrayList<T> res = new ArrayList<>();
        for (T e: list) {
            if (f.call(e)) {
                res.add(e);
            }
        }
        return res;
    }

    static <T> T acc(ArrayList<T> list, BinaryFunction<T, T, T> f) {
        T acc = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            acc = f.call(acc, list.get(i));
        }
        return acc;
    }

    static <T> void forEach(ArrayList<T> list, UnaryFunction<T, Void> f) {
        for(T e: list) {
            f.call(e);
        }
    }

    private void functional_interfaces_example() {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8, 9));
        System.out.println(apply(A, new UnaryFunction<Integer, Integer>() {
            @Override
            public Integer call(Integer arg) {
                return arg * 2;
            }
        }));
        System.out.println(apply(A, (Integer arg) -> {return arg.toString();} ));
        System.out.println(apply(A, (x) -> x * x));
        System.out.println(apply(A, (x) -> Math.sqrt(x)));


        System.out.println(select(A, (x) -> x > 2 ));
        System.out.println(select(A, (x) -> x%2 == 0));

        System.out.println(acc(A, (x, y) -> x + y));
        System.out.println(acc(A, (x, y) -> Math.max(x, y)));

        forEach(A, (n) -> {
            for (int i = 0; i < n; i++)
                System.out.print("*");
            System.out.println();
            return null;
        } );
    }

    private void functions_by_reference_example() {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8, 9));

        System.out.println(acc(A, Math::max));
        System.out.println(apply(A, (UnaryFunction<Integer, Double>)Math::sqrt));
        System.out.println(apply(A, Object::toString));
    }

    private void closure_example() {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8, 9));

        int inc = 4;
        System.out.println(apply(A, (x) -> x+inc));
        // inc = 5; // try to change that variable later in the code
    }

    public void demo() {
        functional_interfaces_example();
        functions_by_reference_example();
        closure_example();
    }
}
