import java.util.Arrays;

public class Main {
    //Создал массив типа Employee
    public static Employee[] info = new Employee[10];

    //Создал метод "Получить список всех сотрудников со всеми имеющимися по ним данными
    // (вывести в консоль значения всех полей (toString));"


    //Создал метод "Посчитать сумму затрат на ЗП в месяц"
    public static double countSumSalary() {
        double totalSalary = 0;
        for (int i = 0; i < info.length; i++) {
            if (info[i] != null) {
                totalSalary = info[i].getSalary() + totalSalary;

            }
        }
        return totalSalary;
    }

    //Создал метод "Найти сотрудника с минимальной ЗП;"
    public static Employee findPersonWithMinSalary() {
        double minSalary = Double.MAX_VALUE;
        int i = 0;
        for (int index = 0; index < info.length; index++) {
            if (info[index] != null && minSalary > info[index].getSalary()) {
                minSalary = info[index].getSalary();
                i = index;

            }
        }
        return info[i];
    }

    //Создал метод "Найти сотрудника с максимальной ЗП;"
    public static Employee findPersonWithMaxSalary() {
        double maxSalary = Double.MIN_VALUE;
        int i = 0;
        for (int index = 0; index < info.length; index++) {
            if (info[index] != null && maxSalary < info[index].getSalary()) {
                maxSalary = info[index].getSalary();
                i = index;
            }
        }
        return info[i];
    }

    //Создал метод "Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b);"
    public static double countMiddleSalary() {
        int count = 0;
        double totalSalary = 0;
        for (int i = 0; i < info.length; i++) {
            if (info[i] != null) {
                count += 1;
                totalSalary = info[i].getSalary() + totalSalary;
            }
        }
        if (count != 0) {
            double middleSalary = totalSalary / count;
            return middleSalary;
        } else {
            return count;
        }
    }

    //Создал метод "Распечатать ФИО всех сотрудников (метод ничего)."
    public static void printFullName() {
        for (int i = 0; i < info.length; i++) {
            if (info[i] != null) {
                System.out.println(info[i].getFullName());
            }
        }
    }

    //Создал метод "Проиндексировать зарплату (вызвать изменение зп у всех сотрудников на величину аргумента в %)"
    public static void changeSalaryOnPercent(double percentForEveryonePerson) {
        for (int i = 0; i < info.length; i++) {
            if (info[i] != null) {
                info[i].setSalary(info[i].getSalary() * (1 + percentForEveryonePerson / 100));
            }
        }
    }

    //Создал метод "Получить в качестве параметра номер отдела (1-5) и найти"
    //Сотрудника с минимальной зп;
    public static Employee findMinSalaryInDepartment(int numberDepartment) {
        double minSalary = Double.MAX_VALUE;
        int i = 0;
        for (int index = 0; index < info.length; index++) {
            if (info[index] != null && info[index].getDepartment() == numberDepartment && minSalary > info[index].getSalary()) {
                minSalary = info[index].getSalary();
                i = index;
            }
        }
        return info[i];
    }

    //Создал метод "Получить в качестве параметра номер отдела (1-5) и найти"
    //Сотрудника с максимальной зп;
    public static Employee findMaxSalaryInDepartment(int numberDepartment) {
        double maxSalary = Double.MIN_VALUE;
        int i = 0;
        for (int index = 0; index < info.length; index++) {
            if (info[index] != null && info[index].getDepartment() == numberDepartment && maxSalary < info[index].getSalary()) {
                maxSalary = info[index].getSalary();
                i = index;
            }
        }
        return info[i];
    }

    //Создал метод "Получить в качестве параметра номер отдела (1-5) и найти"
    //Сумму затрат на зп по отделу;
    public static double countTotalSalaryInDepartment(int numberDepartment) {
        double sumSalary = 0;
        for (int i = 0; i < info.length; i++) {
            if (info[i] != null && info[i].getDepartment() == numberDepartment) {
                sumSalary = sumSalary + info[i].getSalary();
            }
        }
        return sumSalary;
    }

    //Создал метод "Получить в качестве параметра номер отдела (1-5) и найти"
    //Среднюю зп по отделу (учесть, что количество людей в отделе отличается от employees.length);
    public static double countMiddleSalaryInDepartment(int numberDepartment) {
        double sumSalary = 0;
        int count = 0;
        for (int i = 0; i < info.length; i++) {
            if (info[i] != null && info[i].getDepartment() == numberDepartment) {
                count += 1;
                sumSalary = sumSalary + info[i].getSalary();
            }
        }
        if (count != 0) {
            double middleSalary = sumSalary / count;
            return middleSalary;
        } else {
            return count;

    }}

    //Создал метод "Получить в качестве параметра номер отдела (1-5) и найти"
    //Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра;
    public static void upPercentInDepartment(int numberDepartment, double percentUpSalaryInDepartment) {
        for (int i = 0; i < info.length; i++) {
            if (info[i] != null && info[i].getDepartment() == numberDepartment) {
                info[i].setSalary(info[i].getSalary() * (1 + percentUpSalaryInDepartment / 100));
            }
        }
    }

    //Создал метод "Получить в качестве параметра номер отдела (1-5) и найти"
    //Напечатать всех сотрудников отдела (все данные, кроме отдела).
    public static void printInfoInDepartment(int numberDepartment) {
        for (int i = 0; i < info.length; i++) {
            if (info[i] != null && info[i].getDepartment() == numberDepartment) {
                printInfo(info, i);
            }
        }
    }

    //Создал метод "Получить в качестве параметра число и вывести:
    // Всех сотрудников с зп меньше числа (распечатать id, фио и зп в консоль);"
    public static void findPersonsWithSalaryLessSalaryForSelectionEmployees(
            double salaryForSelectionEmployees) {
        System.out.println("Сотрудники с зарплатой <" + salaryForSelectionEmployees + " :");
        for (int i = 0; i < info.length; i++) {
            if (info[i] != null && info[i].getSalary() < salaryForSelectionEmployees) {
                printInfo(info, i);
            }
        }
    }

    //Создал метод "Получить в качестве параметра число и вывести:
    //Всех сотрудников с зп больше (или равно) числа (распечатать id, фио и зп в консоль)."
    public static void findPersonsWithSalaryMoreSalaryForSelectionEmployees(
            double salaryForSelectionEmployees) {
        System.out.println("Сотрудники с зарплатой >=" + salaryForSelectionEmployees + " :");
        for (int i = 0; i < info.length; i++) {
            if (info[i] != null && info[i].getSalary() >= salaryForSelectionEmployees) {
                printInfo(info, i);
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

    public static void main(String[] args) {
////////БАЗОВАЯ СЛОЖНОСТЬ////////////
        ////////////////////////////////////
        info[0] = new Employee("Ivanov Ivan Ivanovich", 10_000, 2);
        info[1] = new Employee("Petrov Petr Petrovich", 50_000, 1);
        info[2] = new Employee("Sergeev Sergei Sergeevich", 1_000, 3);
        info[3] = new Employee("Denisov Denis Denisovich", 60_000, 3);
        info[4] = new Employee("Abrikosov Dmitriy Borisovich", 100_000, 2);
        info[5] = new Employee("Kulikov Stepan Ivanovich", 70_000, 2);
        info[6] = new Employee("Sidorov Mihail Mihailovich", 30_000, 1);
        info[7] = new Employee("Plahov Oleg Olegovich", 90_000, 4);
        info[8] = new Employee("Mironov Nikita Aleksandrovich", 150_000, 1);
        info[9] = new Employee("Sundukov Aleksei Evgenevich", 5_000, 1);
        //Вызываем метод для " Получить список всех сотрудников со всеми имеющимися по ним данными
        // (вывести в консоль значения всех полей (toString));"
        System.out.println(Arrays.toString(info));
        //Вызываем метод для "Посчитать сумму затрат на ЗП в месяц"
        double totalSalary = Main.countSumSalary();
        System.out.println("Сумма затрат на ЗП в месяц = " + totalSalary);
        //Вызываем метод для "Найти сотрудника с минимальной ЗП;"
        Employee personWithMinSalary = Main.findPersonWithMinSalary();
        System.out.println("Cотрудник с минимальной ЗП " + personWithMinSalary);
        //Вызываем метод для "Найти сотрудника с максимальной ЗП;"
        Employee personWithMaxSalary = Main.findPersonWithMaxSalary();
        System.out.println("Cотрудник с максимальной ЗП " + personWithMaxSalary);
        //Вызываем метод для "Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b);"
        double middleSalary = Main.countMiddleSalary();
        System.out.println("Среднее значение зарплат = " + middleSalary);
        //Вызываем метод для "Распечатать ФИО всех сотрудников (метод ничего)."
        Main.printFullName();
        //////////////////////ПОВЫШЕННАЯ СЛОЖНОСТЬ//////////////////
        ///////////////////////////////////////////////////////////
        //Вызываем метод для "Проиндексировать зарплату (вызвать изменение зп у всех сотрудников на величину аргумента в %)"
        double percentForEveryonePerson = 0;//для второго задания (индексация сотрудников)
        Main.changeSalaryOnPercent(percentForEveryonePerson);
        // System.out.println("info[4].getSalary() = " + info[4].getSalary());
        //Назначаем номер отдела для отбора сотрудников по отделам
        int numberDepartment = 2;// nomberDepartment может быть от 1 до 5 включительно
        //Вызываем метод для "Получить в качестве параметра номер отдела (1-5) и найти"
        ////Сотрудника с минимальной зп;
        //  Employee personWithMinSalaryInDepartment=Employee.
        Employee personWithMinSalaryInDepartment = Main.findMinSalaryInDepartment(numberDepartment);
        System.out.println("Cотрудник в отделе " + numberDepartment + " c минимальной ЗП " + personWithMinSalaryInDepartment);
        //Вызываем метод для "Получить в качестве параметра номер отдела (1-5) и найти"
        ////Сотрудника с максимальной зп;
        Employee personWithMaxSalaryInDepartment = Main.findMaxSalaryInDepartment(numberDepartment);
        System.out.println("Cотрудник в отделе " + numberDepartment + " c максимальной ЗП " + personWithMaxSalaryInDepartment);
        //Вызываем метод для "Получить в качестве параметра номер отдела (1-5) и найти"
        ////Сумму затрат на зп по отделу;
        Main.countTotalSalaryInDepartment(numberDepartment);
        System.out.println("Сумма затрат на зп по отделу " + numberDepartment + " равна " + Main.countTotalSalaryInDepartment(numberDepartment));
        //Вызываем метод для "Получить в качестве параметра номер отдела (1-5) и найти"
        ////Среднюю зп по отделу (учесть, что количество людей в отделе отличается от employees.length);
        Main.countMiddleSalaryInDepartment(numberDepartment);
        System.out.println("Средняя зп по отделу " + numberDepartment + " равна " + Main.countMiddleSalaryInDepartment(numberDepartment));
        //Вводим процент индексации зарплаты сотрудноков в отделе
        double percentUpSalaryInDepartment = 0;
        //Вызываем метод для "Получить в качестве параметра номер отдела (1-5) и найти"
        ////Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра;
        Main.upPercentInDepartment(numberDepartment, percentUpSalaryInDepartment);
        //Вызываем метод для "Получить в качестве параметра номер отдела (1-5) и найти"
        ////Напечатать всех сотрудников отдела (все данные, кроме отдела).
        Main.printInfoInDepartment(numberDepartment);
        //Назначаем число для отбора сотрудников по зарплате больше/меньше salaryForSelectionEmployees
        double salaryForSelectionEmployees = 18_000;
        //Вызываем метод для "Получить в качестве параметра число и вывести:
        // Всех сотрудников с зп меньше числа (распечатать id, фио и зп в консоль);"
        Main.findPersonsWithSalaryLessSalaryForSelectionEmployees(salaryForSelectionEmployees);
        //Вызываем метод для "Получить в качестве параметра число и вывести:
        //Всех сотрудников с зп больше (или равно) числа (распечатать id, фио и зп в консоль)."
        Main.findPersonsWithSalaryMoreSalaryForSelectionEmployees(salaryForSelectionEmployees);


    }
}