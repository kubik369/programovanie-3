package workbalance;

interface WorkUnit {
    final int DEFAULT_OFFSET = 4;
    public int getSalary();
    public String repr();
    public String repr(int offset);
    public void addWorkload(int load);
    public int getCurrentWorkload();
    public Worker getWorkerWithLowestWorkload();
}
