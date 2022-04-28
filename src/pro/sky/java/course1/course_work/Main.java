package pro.sky.java.course1.course_work;

public class Main {

    public static void main(String[] args) {
        double sumSalary = 0;
        Employee empMinSalary;
        Employee empMaxSalary;
        double avgSalary = 1d;
        Employee emMinSalDep2;
        Employee emMaxSalDep2;
        double emSumSalDep1;
        double avgSalEmpDep1;

        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.addEmployee("Гарри Поттер", 1, 50_000);
        employeeBook.addEmployee("Гермиона Грейнджер", 1, 40_000);
        employeeBook.addEmployee("Рон Уизли", 1, 30_000);
        employeeBook.addEmployee("Драко Малфой", 2, 80_000);
        employeeBook.addEmployee("Чжоу Чанг", 4, 35_000);
        employeeBook.addEmployee("Седрик Диггори", 3, 45_000);
        employeeBook.addEmployee("Северус Снегг", 2, 100_000);
        employeeBook.addEmployee("Полумна Лавгуд", 4, 50_000);
        employeeBook.addEmployee("Захария Смит", 3, 25_000);
        employeeBook.addEmployee("Альбус Дамблдор", 1, 200_000);
        employeeBook.addEmployee("Том Реддл", 2, 110_000);
        employeeBook.addEmployee("Златопуст Локонс", 4, 60_000);
        employeeBook.addEmployee("Джастин Финч-Флетчли", 3, 35_000);
        employeeBook.removeEmployee("Седрик Диггори", null);

        employeeBook.printAllEmployees();
        sumSalary = employeeBook.defineSumSalary(employeeBook.getEmployees());
        System.out.println("Сумма затрат на зарплаты в месяц равна " + sumSalary);
        empMinSalary = employeeBook.defineEmpMinSal(employeeBook.getEmployees());
        empMaxSalary = employeeBook.defineEmpMaxSal(employeeBook.getEmployees());
        System.out.println("Сотрудник с минимальной зарплатой - " + empMinSalary.getName());
        System.out.println("Сотрудник с максимальной зарплатой - " + empMaxSalary.getName());
        avgSalary = employeeBook.defineAvgSalary(sumSalary, employeeBook.getEmployees().length);
        System.out.println("Среднее значение зарплат равно " + avgSalary);
        employeeBook.printAllEmployeesName();
        employeeBook.raiseSalary(employeeBook.getEmployees(),10);

        emMinSalDep2 = employeeBook.findMinOrMaxOfDep(employeeBook.rebuildOfDep(2), "min");
        System.out.println("Сотрудник с минимальной зарплатой в отделе 2 - " + emMinSalDep2.getName());
        emMaxSalDep2 = employeeBook.findMinOrMaxOfDep(employeeBook.rebuildOfDep(2), "max");
        System.out.println("Сотрудник с максимальной зарплатой в отделе 2 - " + emMaxSalDep2.getName());
        emSumSalDep1 = employeeBook.defineSumSalary(employeeBook.rebuildOfDep(1));
        System.out.println("Сумма затрат на зарплату по отделу 1 = " + emSumSalDep1);
        avgSalEmpDep1 = employeeBook.defineAvgSalary(emSumSalDep1, employeeBook.rebuildOfDep(1).length);
        System.out.println("Средняя зарплата по отделу 1 = " + avgSalEmpDep1);
        employeeBook.raiseSalary(employeeBook.rebuildOfDep(3),15);
        employeeBook.printEmpDep(employeeBook.rebuildOfDep(1));
        employeeBook.printEmpMore(100_000);
        employeeBook.printEmpLess(50_000);

        employeeBook.changeEmployee("Гарри Поттер", 150_000, null);
        employeeBook.changeEmployee("Северус Снегг", null, 1);
        employeeBook.printEmpOrdDep();

    }
}
