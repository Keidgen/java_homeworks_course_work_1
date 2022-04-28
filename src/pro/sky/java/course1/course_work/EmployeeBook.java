package pro.sky.java.course1.course_work;

import java.util.Arrays;

public class EmployeeBook {
    private Employee[] employees = new Employee[1];

    public Employee[] getEmployees() {
        return employees;
    }

    public void addEmployee(String name, int department, int salary) {
        Employee newEmployee = new Employee(name, department, salary);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = newEmployee;
                return;
            }
        }

        Employee[] newEmployees = new Employee[employees.length + 1];

        for (int i = 0; i < employees.length; i++) {
            newEmployees[i] = employees[i];
        }
        newEmployees[newEmployees.length - 1] = newEmployee;
        employees = newEmployees;
    }

    public void removeEmployee(String name, Integer employeeId) {
        if (name == null && employeeId == null) {
            System.out.println("Для удаления сотрудника не хватает параметров");
            return;
        }
        Employee employeeTemp = findEmployee(name, employeeId);
        if (employeeTemp != null) {
            for (int i = 0; i < employees.length; i++) {
                Employee employee = employees[i];
                if (employee.equals(employeeTemp)) {
                    employees[i] = null;
                    return;
                }
            }
        }
    }

    public Employee findEmployee(String name, Integer employeeId) {
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employee == null) {
                continue;
            }
            if (employeeId != null && employee.getId() == employeeId) {
                return employee;
            }
            if (name != null && employee.getName() == name) {
                return employee;
            }
        }
        return null;
    }

    public void printAllEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.toString());
            }
        }
    }

    public void printEmpDep(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getName() + ": " + employee.getSalary());
            }
        }
    }

    public double defineSumSalary(Employee[] employees) {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum = sum + employee.getSalary();
            }
        }
        return sum;
    }

    public Employee defineEmpMinSal(Employee[] employees) {
        double min = 1_000_000;
        Employee minEmp = new Employee(" ", 0, 0);
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < min) {
                min = employee.getSalary();
                minEmp = employee;
            }
        }
        return minEmp;
    }

    public Employee defineEmpMaxSal(Employee[] employees) {
        double max = 0;
        Employee maxEmp = new Employee(" ", 0, 0);
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > max) {
                max = employee.getSalary();
                maxEmp = employee;
            }
        }
        return maxEmp;
    }

    public double defineAvgSalary(double sumSalary, int cntEmp) {
        return sumSalary/cntEmp;
    }

    public void printAllEmployeesName() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getName());
            }
        }
    }

    public void raiseSalary(Employee[] employees, double prcRaise) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                Employee emp = employees[i];
                double currentSal = emp.getSalary();
                double actualSal = currentSal + ((currentSal / 100) * prcRaise);
                emp.setSalary(actualSal);
            }
        }
    }

    public Employee[] rebuildOfDep(int department) {
        int idx = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                Employee emp = employees[i];
                if (emp.getDepartment() != department) {
                    idx++;
                }
            }
        }
        Employee[] employeeTemp = new Employee[employees.length-idx];

        int j = 0;
        for (int i = 0; i < employees.length; i++) {
            Employee emp = employees[i];
            if (emp == null || emp.getDepartment() != department) {
                continue;
            }
            employeeTemp[j] = emp;
            j++;
        }
        return employeeTemp;
    }
    public Employee findMinOrMaxOfDep(Employee[] employees, String direct) {
        Employee valEmp = null;
        switch (direct) {
            case "max":
                valEmp = defineEmpMaxSal(employees);
                break;
            case "min":
                valEmp = defineEmpMinSal(employees);
                break;
        }

        return valEmp;
    }

    public void printEmpMore(double num) {
        for (int i = 0; i < employees.length; i++) {
            if (i == 0) {
                System.out.println("Cотрудники с зарплатой больше, чем " + num);
            }
            Employee emp = employees[i];
            if (emp != null && emp.getSalary() >= num) {
                System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getSalary());
            }
        }
    }
    public void printEmpLess(double num) {
        for (int i = 0; i < employees.length; i++) {
            if (i == 0) {
                System.out.println("Cотрудники с зарплатой меньше, чем " + num);
            }
            Employee emp = employees[i];
            if (emp != null && emp.getSalary() < num) {
                System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getSalary());
            }
        }
    }

    public void changeEmployee(String name, Integer salary, Integer department) {
        if (name == null ) {
            System.out.println("Ошибка. Отсутствует имя сотрудника!");
            return;
        } else if (salary == null && department == null) {
            System.out.println("Ошибка. Отсутствуют данные для изменения!");
            return;
        }
        Employee employeeChange = findEmployee(name, null);
        if (salary != null) {
            employeeChange.setSalary(salary);
        }
        if (department != null) {
            employeeChange.setDepartment(department);
        }
    }

    public void printEmpOrdDep() {
        int idx = 0;
        int j = 0;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                idx++;
            }
        }
        Employee[] employeesTemp = new Employee[idx];

        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
            if (employees[i] != null) {
                employeesTemp[j] = employees[i];
                j++;
            }
        }

        Arrays.sort(employeesTemp);
        for (int i = 0; i < employeesTemp.length; i++) {
            System.out.println("Отдел: " + employeesTemp[i].getDepartment() + "; Сотрудник: " + employeesTemp[i].getName());
        }
    }
}
