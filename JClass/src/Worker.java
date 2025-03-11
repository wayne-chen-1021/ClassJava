public class Worker {
    private String name;
    private int salary;
    public Worker(String name) {
        this(name, 25000);
    }
    public Worker(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}

class WorkerTestDriver {
    Worker Peter = new Worker("Peter");
    Worker Sunny = new Worker("Sunny", 100);
}
