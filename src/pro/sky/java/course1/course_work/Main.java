package pro.sky.java.course1.course_work;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        int sumSalary = 0;
        Employee empMinSalary = new Employee(" ",0,0);
        Employee empMaxSalary = new Employee(" ",0,0);
        double avgSalary = 1d;
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
                    name = "Том Реддл"; department = 1; salary = 110_000;
                    break;
                case 9:
                    name = "Златопуст Локонс"; department = 4; salary = 60_000;
                    break;
                default: break;

            }
            employees[i] = new Employee(name, department, salary);
        }

        printAllEmployees(employees);
        sumSalary = defineSumSalary(employees);
        System.out.println("Сумма затрат на зарплаты в месяц равна " + sumSalary);
        empMinSalary = defineEmpMinSal(employees);
        empMaxSalary = defineEmpMaxSal(employees);
        System.out.println("Сотрудник с минимальной зарплатой - " + empMinSalary.getName());
        System.out.println("Сотрудник с максимальной зарплатой - " + empMaxSalary.getName());
        avgSalary = defineAvgSalary(sumSalary, employees);
        System.out.println("Среднее значение зарплат равно " + avgSalary);
        printAllEmployeesName(employees);
    }

    public static void printAllEmployees(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    public static int defineSumSalary(Employee[] employees) {
        int sum = 0;
        for (Employee employee : employees) {
            sum = sum + employee.getSalary();
        }
        return sum;
    }

    public static Employee defineEmpMinSal(Employee[] employees) {
        int min = 1_000_000;
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
        int max = 0;
        Employee maxEmp = new Employee(" ", 0, 0);
        for (Employee employee : employees) {
            if (employee.getSalary() > max) {
                max = employee.getSalary();
                maxEmp = employee;
            }
        }
        return maxEmp;
    }

    public static double defineAvgSalary(int sumSalary, Employee[] employees) {
        return sumSalary/employees.length;
    }

    public static void printAllEmployeesName(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }
    }
}
