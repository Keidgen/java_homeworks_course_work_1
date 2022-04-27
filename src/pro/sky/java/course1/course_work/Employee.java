package pro.sky.java.course1.course_work;

public class Employee {
    private int id;
    static int counter = 1;

    private String name;
    private int department;
    private double salary;

    public Employee(String name, int department, int salary) {
        this.id = counter;
        this.name = name;
        this.department = department;
        this.salary = salary;
        counter++;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + ": " + department + ": " + salary;
    }
}
