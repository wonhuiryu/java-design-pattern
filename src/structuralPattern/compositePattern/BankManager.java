package structuralPattern.compositePattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BankManager implements Employee {

    private int id;
    private String name;
    private double salary;

    public BankManager(int id, String name, double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    List<Employee> employeeList = new ArrayList<>();

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

        Iterator<Employee> it = employeeList.iterator();

        while(it.hasNext())  {
            Employee employee = it.next();
            employee.print();
        }
    }

    @Override
    public void add(Employee employee) {
        employeeList.add(employee);
    }

    @Override
    public void remove(Employee employee) {
        employeeList.remove(employee);
    }

    @Override
    public Employee getChild(int i) {
        return employeeList.get(i);
    }
}
