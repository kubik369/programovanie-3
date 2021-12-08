package dnd;

class Main {
    public static void main(String[] args)   {
        System.out.println("=========D6=========");
        MyRandom random = new StandardRandom();
        D6 d6 = new D6(random);
        for (int i = 0; i < 10; i++) {
            System.out.print(d6.nextValue());
            System.out.print(" ");
        }
        System.out.println();

        System.out.println("=========D4=========");
        D4 d4 = new D4(random);
        for (int i = 0; i < 10; i++) {
            System.out.print(d4.nextValue());
            System.out.print(" ");
        }
        System.out.println();

        System.out.println("=========D5=========");
        Dn d5 = new Dn(random, 5);
        for (int i = 0; i < 10; i++) {
            System.out.print(d5.nextValue());
            System.out.print(" ");
        }
        System.out.println();

        System.out.println("=========testDistribution D5=========");
        DieTester.testDistribution(d5, 100);

        System.out.println("=========LCG=========");
        LCG lcg = new LCG(65539, 0, 2147483648L, 47);
        System.out.println("=====D4=====");
        d4.setGenerator(lcg);
        for (int i = 0; i < 10; i++) {
            System.out.print(d4.nextValue());
            System.out.print(" ");
        }
        System.out.println();
        DieTester.testDistribution(d4, 100);
        
        System.out.println("=====D6=====");
        d6.setGenerator(lcg);
        for (int i = 0; i < 10; i++) {
            System.out.print(d6.nextValue());
            System.out.print(" ");
        }
        System.out.println();
        DieTester.testDistribution(d6, 100);

        System.out.println("=====D4=====");
        lcg = new LCG(1103515245, 12345, 2147483648L, 47);
        d4.setGenerator(lcg);
        for (int i = 0; i < 10; i++) {
            System.out.print(d4.nextValue());
            System.out.print(" ");
        }
        System.out.println();
        DieTester.testDistribution(d4, 100);

        System.out.println("=====D6=====");
        lcg = new LCG(1103515245, 12345, 2147483648L, 47);
        d6.setGenerator(lcg);
        for (int i = 0; i < 10; i++) {
            System.out.print(d6.nextValue());
            System.out.print(" ");
        }
        System.out.println();
        DieTester.testDistribution(d6, 100);
    }
}