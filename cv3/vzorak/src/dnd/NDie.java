package dnd;

interface NDie {
    public int nextValue();
    public int getSidesCount();
    public void setGenerator(MyRandom random);
}