package structuralPattern.compositePattern;

public class Accountant implements Employee {//not justify method

    private int id;
    private String name;
    private double salary;

/*    List<Employee> employeeList = new ArrayList<>();*/

    public Accountant(int id, String name, double salary){
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
        System.out.println("=========================");
        System.out.println("Id ="+getId());
        System.out.println("Name ="+getName());
        System.out.println("Salary ="+getSalary());
        System.out.println("=========================");
    }

    @Override
    public void add(Employee employee) {
/*        employeeList.add(employee);*/
    }

    @Override
    public void remove(Employee employee) {
        /*employeeList.remove(employee);*/
    }

    @Override
    public Employee getChild(int i) {
        /*return employeeList.get(i);*/
        return null;
    }
}
