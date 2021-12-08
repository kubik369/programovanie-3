package dnd;

import java.util.Random;

class StandardRandom implements MyRandom {
    Random random = new Random();

    @Override
    public long nextLong() {
        return this.random.nextLong();
    }
}