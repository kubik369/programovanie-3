package dnd;

import java.util.Random;

class Dn implements NDie {
    MyRandom random;
    private final int numberOfSides;

    public Dn(MyRandom random, int numberOfSides) {
        this.random = random;
        this.numberOfSides = numberOfSides;
    }

    public int nextValue() {
        return (int)Math.abs(this.random.nextLong() % this.numberOfSides);
    }

    public int getSidesCount() {
        return this.numberOfSides;
    }

    @Override
    public void setGenerator(MyRandom newGenerator) {
        this.random = newGenerator;
    }
}