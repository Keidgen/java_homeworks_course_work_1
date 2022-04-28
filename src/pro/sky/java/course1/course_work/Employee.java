package pro.sky.java.course1.course_work;

import java.util.Objects;

public class Employee implements Comparable {
    private int id;
    static int counter = 1;

    private String name;
    private Integer department;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public int compareTo(Object obj)
    {
        Employee tmp = (Employee) obj;

        //используем метод compareTo из класса String для сравнения имен
        int result = this.department.compareTo(tmp.department);

        //если имена одинаковые -  сравниваем возраст, используя метод compareTo из класса Integer

        if (result == 0) {
            result = this.name.compareTo(tmp.name);
        }
        return result;
    }

}
