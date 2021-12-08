package dnd;

class LCG implements MyRandom {
    private final long a;
    private final long c;
    private final long m;
    private final long seed;
    private long currentState;

    public LCG(long a, long c, long m, long seed) {
        this.a = a;
        this.c = c;
        this.m = m;
        this.seed = seed;
        this.currentState = seed;
        this.nextLong();
    }

    @Override
    public long nextLong() {
        long nextNumber = this.currentState;
        this.currentState = (this.a * this.currentState + this.c) % this.m;
        return nextNumber;
    }
}
