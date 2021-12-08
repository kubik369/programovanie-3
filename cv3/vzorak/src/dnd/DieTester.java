package dnd;

class DieTester {
    public static void testDistribution(NDie die, int tries) {
        int[] counters = new int[die.getSidesCount()];
        for (int i = 0; i < tries; i++) {
            int numberFromDie = die.nextValue();
            counters[numberFromDie]++;
        }

        System.out.println("Counts:");
        for (int i = 0; i < counters.length; i++) {
            System.out.println(String.format("%d: %d times", i + 1, counters[i]));
        }
        System.out.println("Entropy: " + Double.toString(DieTester.evalEntropy(counters, tries)));
    }

    private static double evalEntropy(int[] counters, int tries) {
        double entropy = 0;
        for (int i = 0; i < counters.length; i++) {
            entropy += -((double)counters[i] / (double)tries) * (Math.log((double)counters[i] / (double)tries) / Math.log(2));
        }
        return entropy;
    }
}