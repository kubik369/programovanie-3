package workbalance;

class Main {
    public static void main(String[] args)   {
        Worker w1 = new Worker("Jakub", 12);
        Worker w2 = new Worker("Lenka", 5);
        Worker w3 = new Worker("Jitka", 34);
        Worker w4 = new Worker("Ivka", 2);
        Worker w5 = new Worker("Krtko", 50);
        Team t1 = new Team("Dream Team");
        Team t2 = new Team("A Team");
        Team t3 = new Team("A Team");
        
        t1.addMember(w1);
        t1.addMember(w3);
        t2.addMember(t1);
        t2.addMember(w2);
        t2.addMember(w4);
        System.out.println(w1.getSalary());
        System.out.println(t1.getSalary());
        System.out.println(t1.repr());
        System.out.println(t2.repr());

        w1.addWorkload(1);
        w2.addWorkload(10);
        w3.addWorkload(5);
        w4.addWorkload(7);
        w5.addWorkload(15);
        System.out.println(t1.repr());
        System.out.println(t2.repr());
    }
}