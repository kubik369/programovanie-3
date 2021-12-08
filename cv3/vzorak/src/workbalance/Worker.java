package workbalance;

class Worker implements WorkUnit {
    private int salary;
    private int workload;
    private String name;
    
    public Worker(String name, int salary) {
        this.name = name;
        this.salary = salary;
        this.workload = 0;
    }

    @Override
    public int getSalary() {
        return this.salary;
    }

    @Override
    public String repr() {
        return this.repr(DEFAULT_OFFSET);
    }

    public String repr(int offset) {
        return " ".repeat(offset)
            + String.format(
                "%s (salary: %d, workload: %d)",
                this.name,
                this.salary,
                this.workload
            );
    }

    @Override
    public void addWorkload(int load) {
        this.workload += load;
    }
    
    @Override
    public int getCurrentWorkload() {
        return this.workload;
    }

    public Worker getWorkerWithLowestWorkload() {
        return this;
    }
}
