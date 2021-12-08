package workbalance;

import java.util.ArrayList;

class Team implements WorkUnit {
    private String name;
    private ArrayList<WorkUnit> members = new ArrayList<WorkUnit>();

    public Team(String name) {
        this.name = name;
    }

    public void addMember(WorkUnit unit) {
        this.members.add(unit);
    }

    @Override
    public int getSalary() {
        int totalSalary = 0;
        for (WorkUnit unit : this.members) {
            totalSalary += unit.getSalary();
        }
        return totalSalary;
    }

    @Override
    public String repr() {
        return this.repr(0);
    }

    public String repr(int offset) {
        String teamRepresentation = String.format(
            "%s%s (total salary: %d, total workload: %d)\n",
            " ".repeat(offset),
            this.name,
            this.getSalary(),
            this.getCurrentWorkload()
        );

        for (int i = 0; i < this.members.size(); i++) {
            teamRepresentation += this.members
                .get(i)
                .repr(offset + DEFAULT_OFFSET)
                .replaceAll("\n", " ".repeat(offset) + "\n")
                + (i == this.members.size() - 1 ? "" : "\n");
        }

        return teamRepresentation;
    }

    @Override
    public void addWorkload(int load) {
        this.getWorkerWithLowestWorkload().addWorkload(load);
    }

    public Worker getWorkerWithLowestWorkload() {
        if (this.members.isEmpty()) {
            return null;
        }
        WorkUnit lowestLoadWorker = new Worker("Dummy", Integer.MAX_VALUE);
        for (WorkUnit unit : this.members) {
            WorkUnit candidate = unit.getWorkerWithLowestWorkload();
            if (lowestLoadWorker.getCurrentWorkload() > candidate.getCurrentWorkload()) {
                lowestLoadWorker = candidate;
            }
        }
        return (Worker)lowestLoadWorker;
    }
    
    @Override
    public int getCurrentWorkload() {
        int load = 0;
        for (WorkUnit unit : this.members) {
            load += unit.getCurrentWorkload();
        }
        return load;
    }
}