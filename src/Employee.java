import java.util.Objects;

public class Employee {
    private String fullName;
    private double salary;
    private int department;
    private int id;
    static int counter = 1;
    private final int COUNT_DEPARTMENT = 5;

    //Создал конструктор класса Employee
    public Employee(String fullName, double salary, int department) {
        this.fullName = fullName;
        this.salary = salary;
        this.department = department;
        id = counter++;
        printErrorDepartment(department, COUNT_DEPARTMENT);
        printErrorSalary(salary);
        printErrorFullName(fullName);
    }

    public static void printErrorDepartment(int department, int COUNT_DEPARTMENT) {
        if (department < 1 || department > COUNT_DEPARTMENT) {
            throw new RuntimeException("Поле department заполнено не корректно");
        }
    }

    public static void printErrorSalary(double salary) {
        if (salary <= 0) {
            throw new RuntimeException("Поле salary заполнено не корректно");
        }
    }

    public static void printErrorFullName(String fullName) {
        char[] m = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '-', '.', ',', '_', '!', '?', '@', '$', '/',
                '=', '[', ']', '{', '}', '(', ')', '&', '^', '%', '#', ';', '>', '<', '"', '№'};
        char[] c = fullName.toCharArray();
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (c[i] == m[j]) {
                    throw new RuntimeException("Поле fullName заполнено не корректно");
                }
            }
        }
    }

    //Создал геттер id
    public int getId() {
        return this.id;
    }

    //Создал геттер fullName
    public String getFullName() {
        return this.fullName;
    }

    //Создал сеттер salary
    public void setSalary(double salary) {
        this.salary = salary;
    }

    //Создал геттер salary
    public double getSalary() {
        return this.salary;
    }

    //Создал сеттер department
    public void setDepartment(int department) {
        this.department = department;
    }

    //Создал геттер department
    public int getDepartment() {
        return this.department;
    }

    //Создал метод "Получить список всех сотрудников со всеми имеющимися по ним данными
    // (вывести в консоль значения всех полей (toString));"
    @Override
    public String toString() {
        return "id =" + id + ", ФИО =" + fullName + ", зарплата =" + salary + ", отдел =" + department + ";";
    }


    //Создал метод "Посчитать сумму затрат на ЗП в месяц"
    public static double countSumSalary(Employee[] info) {
        double totalSalary = 0;
        for (int i = 0; i < info.length && info[i] != null; i++) {
            totalSalary = info[i].getSalary() + totalSalary;
        }
        return totalSalary;
    }

    //Создал метод "Найти сотрудника с минимальной ЗП;"
    public static Employee findPersonWithMinSalary(Employee[] info) {
        double minSalary = Double.MAX_VALUE;
        int i = 0;
        for (int index = 0; index < info.length && info[index] != null; index++) {
            if (minSalary > info[index].getSalary()) {
                minSalary = info[index].getSalary();
                i = index;
            }
        }
        return info[i];
    }

    //Создал метод "Найти сотрудника с максимальной ЗП;"
    public static Employee findPersonWithMaxSalary(Employee[] info) {
        double maxSalary = Double.MIN_VALUE;
        int i = 0;
        for (int index = 0; index < info.length && info[index] != null; index++) {
            if (maxSalary < info[index].getSalary()) {
                maxSalary = info[index].getSalary();
                i = index;
            }
        }
        return info[i];
    }

    //Создал метод "Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b);"
    public static double countMiddleSalary(Employee[] info) {
        int count = 0;
        for (int i = 0; i < info.length && info[i] != null; i++) {
            count += 1;
        }
        double middleSalary = Employee.countSumSalary(info) / count;
        return middleSalary;
    }

    //Создал метод "Распечатать ФИО всех сотрудников (метод ничего)."
    public static void printFullName(Employee[] info) {
        for (int i = 0; i < info.length && info[i] != null; i++) {
            System.out.println(info[i].getFullName());
        }
    }

    //Создал метод "Проиндексировать зарплату (вызвать изменение зп у всех сотрудников на величину аргумента в %)"
    public static void changeSalaryOnPercent(Employee[] info, double percentForEveryonePerson) {
        for (int i = 0; i < info.length && info[i] != null; i++) {
            info[i].setSalary(info[i].getSalary() * (1 + percentForEveryonePerson / 100));
        }
    }

    //Создал метод "Получить в качестве параметра номер отдела (1-5) и найти"
    //Сотрудника с минимальной зп;
    public static Employee findMinSalaryInDepartment(Employee[] info, int numberDepartment) {
        double minSalary = Double.MAX_VALUE;
        int i = 0;
        for (int index = 0; index < info.length && info[index] != null; index++) {
            if (info[index].getDepartment() == numberDepartment && minSalary > info[index].getSalary()) {
                minSalary = info[index].getSalary();
                i = index;
            }
        }
        return info[i];
    }

    //Создал метод "Получить в качестве параметра номер отдела (1-5) и найти"
    //Сотрудника с максимальной зп;
    public static Employee findMaxSalaryInDepartment(Employee[] info, int numberDepartment) {
        double maxSalary = Double.MIN_VALUE;
        int i = 0;
        for (int index = 0; index < info.length && info[index] != null; index++) {
            if (info[index].getDepartment() == numberDepartment && maxSalary < info[index].getSalary()) {
                maxSalary = info[index].getSalary();
                i = index;
            }
        }
        return info[i];
    }

    //Создал метод "Получить в качестве параметра номер отдела (1-5) и найти"
    //Сумму затрат на зп по отделу;
    public static double countTotalSalaryInDepartment(Employee[] info, int numberDepartment) {
        double sumSalary = 0;
        for (int i = 0; i < info.length && info[i] != null; i++) {
            if (info[i].getDepartment() == numberDepartment) {
                sumSalary = sumSalary + info[i].getSalary();
            }
        }
        return sumSalary;
    }

    //Создал метод "Получить в качестве параметра номер отдела (1-5) и найти"
    //Среднюю зп по отделу (учесть, что количество людей в отделе отличается от employees.length);
    public static double countMiddleSalaryInDepartment(Employee[] info, int numberDepartment) {
        double middleSalary;
        int count = 0;
        for (int i = 0; i < info.length && info[i] != null; i++) {
            if (info[i].getDepartment() == numberDepartment) {
                count += 1;
            }
        }
        middleSalary = Employee.countTotalSalaryInDepartment(info, numberDepartment) / count;
        return middleSalary;
    }

    //Создал метод "Получить в качестве параметра номер отдела (1-5) и найти"
    //Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра;
    public static void upPercentInDepartment(Employee[] info, int numberDepartment, double percentUpSalaryInDepartment) {
        for (int i = 0; i < info.length && info[i] != null; i++) {
            if (info[i].getDepartment() == numberDepartment) {
                info[i].setSalary(info[i].getSalary() * (1 + percentUpSalaryInDepartment / 100));
            }
        }
    }

    //Создал метод "Получить в качестве параметра номер отдела (1-5) и найти"
    //Напечатать всех сотрудников отдела (все данные, кроме отдела).
    public static void printInfoInDepartment(Employee[] info, int numberDepartment) {
        for (int i = 0; i < info.length && info[i] != null; i++) {
            if (info[i].getDepartment() == numberDepartment) {
                Employee.printInfo(info, i);
            }
        }
    }

    //Создал метод "Получить в качестве параметра число и вывести:
    // Всех сотрудников с зп меньше числа (распечатать id, фио и зп в консоль);"
    public static void findPersonsWithSalaryLessSalaryForSelectionEmployees(Employee[] info,
                                                                            double salaryForSelectionEmployees) {
        System.out.println("Сотрудники с зарплатой <" + salaryForSelectionEmployees + " :");
        for (int i = 0; i < info.length && info[i] != null; i++) {
            if (info[i].getSalary() < salaryForSelectionEmployees) {
                Employee.printInfo(info, i);
            }
        }
    }

    //Создал метод "Получить в качестве параметра число и вывести:
    //Всех сотрудников с зп больше (или равно) числа (распечатать id, фио и зп в консоль)."
    public static void findPersonsWithSalaryMoreSalaryForSelectionEmployees(Employee[] info,
                                                                            double salaryForSelectionEmployees) {
        System.out.println("Сотрудники с зарплатой >=" + salaryForSelectionEmployees + " :");
        for (int i = 0; i < info.length && info[i] != null; i++) {
            if (info[i].getSalary() >= salaryForSelectionEmployees) {
                Employee.printInfo(info, i);
            }
        }
    }

    //Создал метод вывода информации
    public static void printInfo(Employee[] info, int i) {
        System.out.print("id " + info[i].getId() + ", ");
        System.out.print("ФИО " + info[i].getFullName() + ", ");
        System.out.print("зарплата " + info[i].getSalary());
        System.out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName);
    }

}
