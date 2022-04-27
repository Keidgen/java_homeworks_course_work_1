package pro.sky.java.course1.course_work;

public class Main {
    static Employee[] employees = new Employee[10];
    public static void main(String[] args) {
        double sumSalary = 0;
        Employee empMinSalary;
        Employee empMaxSalary;
        double avgSalary = 1d;
        Employee emMinSalDep2;
        Employee emMaxSalDep2;
        double emSumSalDep1;
        double avgSalEmpDep1;

        for (int i = 0; i < employees.length; i++) {
            String name = "";
            int department = 0;
            int salary = 0;
            switch (i){
                case 0:
                    name = "Гарри Поттер"; department = 1; salary = 50_000;
                    break;
                case 1:
                    name = "Гермиона Грейнджер"; department = 1; salary = 40_000;
                    break;
                case 2:
                    name = "Рон Уизли"; department = 1; salary = 30_000;
                    break;
                case 3:
                    name = "Драко Малфой"; department = 2; salary = 80_000;
                    break;
                case 4:
                    name = "Седрик Диггори"; department = 3; salary = 45_000;
                    break;
                case 5:
                    name = "Северус Снегг"; department = 2; salary = 100_000;
                    break;
                case 6:
                    name = "Полумна Лавгуд"; department = 4; salary = 50_000;
                    break;
                case 7:
                    name = "Альбус Дамблдор"; department = 1; salary = 200_000;
                    break;
                case 8:
                    name = "Том Реддл"; department = 2; salary = 110_000;
                    break;
                case 9:
                    name = "Златопуст Локонс"; department = 4; salary = 60_000;
                    break;
                default: break;

            }
            employees[i] = new Employee(name, department, salary);
        }

        printAllEmployees();
        sumSalary = defineSumSalary(employees);
        System.out.println("Сумма затрат на зарплаты в месяц равна " + sumSalary);
        empMinSalary = defineEmpMinSal(employees);
        empMaxSalary = defineEmpMaxSal(employees);
        System.out.println("Сотрудник с минимальной зарплатой - " + empMinSalary.getName());
        System.out.println("Сотрудник с максимальной зарплатой - " + empMaxSalary.getName());
        avgSalary = defineAvgSalary(sumSalary, employees.length);
        System.out.println("Среднее значение зарплат равно " + avgSalary);
        printAllEmployeesName();
        raiseSalary(employees,10);

        emMinSalDep2 = findMinOrMaxOfDep(rebuildOfDep(2), "min");
        System.out.println("Сотрудник с минимальной зарплатой в отделе 2 - " + emMinSalDep2.getName());
        emMaxSalDep2 = findMinOrMaxOfDep(rebuildOfDep(2), "max");
        System.out.println("Сотрудник с максимальной зарплатой в отделе 2 - " + emMaxSalDep2.getName());
        emSumSalDep1 = defineSumSalary(rebuildOfDep(1));
        System.out.println("Сумма затрат на зарплату по отделу 1 = " + emSumSalDep1);
        avgSalEmpDep1 = defineAvgSalary(emSumSalDep1, rebuildOfDep(1).length);
        System.out.println("Средняя зарплата по отделу 1 = " + avgSalEmpDep1);
        raiseSalary(rebuildOfDep(3),15);
        printEmpDep(rebuildOfDep(1));
        printEmpMore(100_000);
        printEmpLess(50_000);


    }

    public static void printAllEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    public static void printEmpDep(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee.getName() + ": " + employee.getSalary());
        }
    }

    public static double defineSumSalary(Employee[] employees) {
        double sum = 0;
        for (Employee employee : employees) {
            sum = sum + employee.getSalary();
        }
        return sum;
    }

    public static Employee defineEmpMinSal(Employee[] employees) {
        double min = 1_000_000;
        Employee minEmp = new Employee(" ", 0, 0);
        for (Employee employee : employees) {
            if (employee.getSalary() < min) {
                min = employee.getSalary();
                minEmp = employee;
            }
        }
        return minEmp;
    }

    public static Employee defineEmpMaxSal(Employee[] employees) {
        double max = 0;
        Employee maxEmp = new Employee(" ", 0, 0);
        for (Employee employee : employees) {
            if (employee.getSalary() > max) {
                max = employee.getSalary();
                maxEmp = employee;
            }
        }
        return maxEmp;
    }

    public static double defineAvgSalary(double sumSalary, int cntEmp) {
        return sumSalary/cntEmp;
    }

    public static void printAllEmployeesName() {
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }
    }

    public static void raiseSalary(Employee[] employees, double prcRaise) {
        for (int i = 0; i < employees.length; i++) {
            Employee emp = employees[i];
            double currentSal = emp.getSalary();
            double actualSal = currentSal + ((currentSal / 100) * prcRaise);
            emp.setSalary(actualSal);
        }
    }

    public static Employee[] rebuildOfDep(int department) {
        int idx = 0;
        for (int i = 0; i < employees.length; i++) {
            Employee emp = employees[i];
            if (emp.getDepartment() != department) {
                idx++;
            }
        }
        Employee[] employeeTemp = new Employee[employees.length-idx];

        int j = 0;
        for (int i = 0; i < employees.length; i++) {
            Employee emp = employees[i];
            if (emp.getDepartment() != department) {
                continue;
            }
            employeeTemp[j] = emp;
            j++;
        }
        return employeeTemp;
    }
    public static Employee findMinOrMaxOfDep(Employee[] employees, String direct) {
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

    public static void printEmpMore(double num) {
        for (int i = 0; i < employees.length; i++) {
            if (i == 0) {
                System.out.println("Cотрудники с зарплатой больше, чем " + num);
            }
            Employee emp = employees[i];
            if (emp.getSalary() >= num) {
                System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getSalary());
            }
        }        
    }
    public static void printEmpLess(double num) {
        for (int i = 0; i < employees.length; i++) {
            if (i == 0) {
                System.out.println("Cотрудники с зарплатой меньше, чем " + num);
            }
            Employee emp = employees[i];
            if (emp.getSalary() < num) {
                System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getSalary());
            }
        }
    }

}
