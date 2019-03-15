package structuralPattern.compositePattern;

public class Cashier implements Employee {//not justify method

    private int id;
    private String name;
    private double salary;

/*    private List<Employee> employeeList = new ArrayList<>();*/

    public Cashier(int id, String name, double salary){//생성자도 메소드이므로 접근제어자를 붙여주지 않을 시, default가 됨.
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public void print() {
        System.out.println("==========================");
        System.out.println("Id ="+getId());
        System.out.println("Name ="+getName());
        System.out.println("Salary ="+getSalary());
        System.out.println("==========================");
    }

    @Override
    public void add(Employee employee) {

    }

    @Override
    public void remove(Employee employee) {

    }

    @Override
    public Employee getChild(int i) {
        return null;
    }
}
