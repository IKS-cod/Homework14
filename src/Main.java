import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
////////БАЗОВАЯ СЛОЖНОСТЬ////////////
        ////////////////////////////////////
        //Создал массив типа Employee
        Employee[] info = new Employee[10];
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
        double totalSalary = Employee.countSumSalary(info);
        System.out.println("Сумма затрат на ЗП в месяц = " + totalSalary);
        //Вызываем метод для "Найти сотрудника с минимальной ЗП;"
        Employee personWithMinSalary = Employee.findPersonWithMinSalary(info);
        System.out.println("Cотрудник с минимальной ЗП " + personWithMinSalary);
        //Вызываем метод для "Найти сотрудника с максимальной ЗП;"
        Employee personWithMaxSalary = Employee.findPersonWithMaxSalary(info);
        System.out.println("Cотрудник с максимальной ЗП " + personWithMaxSalary);
        //Вызываем метод для "Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b);"
        double middleSalary = Employee.countMiddleSalary(info);
        System.out.println("Среднее значение зарплат = " + middleSalary);
        //Вызываем метод для "Распечатать ФИО всех сотрудников (метод ничего)."
        Employee.printFullName(info);
        //////////////////////ПОВЫШЕННАЯ СЛОЖНОСТЬ//////////////////
        ///////////////////////////////////////////////////////////
        //Вызываем метод для "Проиндексировать зарплату (вызвать изменение зп у всех сотрудников на величину аргумента в %)"
        double percentForEveryonePerson = 0;//для второго задания (индексация сотрудников)
        Employee.changeSalaryOnPercent(info, percentForEveryonePerson);
        // System.out.println("info[4].getSalary() = " + info[4].getSalary());
        //Назначаем номер отдела для отбора сотрудников по отделам
        int numberDepartment = 1;// nomberDepartment может быть от 1 до 5 включительно
        //Вызываем метод для "Получить в качестве параметра номер отдела (1-5) и найти"
        ////Сотрудника с минимальной зп;
        //  Employee personWithMinSalaryInDepartment=Employee.
        Employee personWithMinSalaryInDepartment = Employee.findMinSalaryInDepartment(info, numberDepartment);
        System.out.println("Cотрудник в отделе " + numberDepartment + " c минимальной ЗП " + personWithMinSalaryInDepartment);
        //Вызываем метод для "Получить в качестве параметра номер отдела (1-5) и найти"
        ////Сотрудника с максимальной зп;
        Employee personWithMaxSalaryInDepartment = Employee.findMaxSalaryInDepartment(info, numberDepartment);
        System.out.println("Cотрудник в отделе " + numberDepartment + " c максимальной ЗП " + personWithMaxSalaryInDepartment);
        //Вызываем метод для "Получить в качестве параметра номер отдела (1-5) и найти"
        ////Сумму затрат на зп по отделу;
        Employee.countTotalSalaryInDepartment(info, numberDepartment);
        System.out.println("Сумма затрат на зп по отделу " + numberDepartment + " равна " + Employee.countTotalSalaryInDepartment(info, numberDepartment));
        //Вызываем метод для "Получить в качестве параметра номер отдела (1-5) и найти"
        ////Среднюю зп по отделу (учесть, что количество людей в отделе отличается от employees.length);
        Employee.countMiddleSalaryInDepartment(info, numberDepartment);
        System.out.println("Средняя зп по отделу " + numberDepartment + " равна " + Employee.countMiddleSalaryInDepartment(info, numberDepartment));
        //Вводим процент индексации зарплаты сотрудноков в отделе
        double percentUpSalaryInDepartment = 0;
        //Вызываем метод для "Получить в качестве параметра номер отдела (1-5) и найти"
        ////Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра;
        Employee.upPercentInDepartment(info, numberDepartment, percentUpSalaryInDepartment);
        //Вызываем метод для "Получить в качестве параметра номер отдела (1-5) и найти"
        ////Напечатать всех сотрудников отдела (все данные, кроме отдела).
        Employee.printInfoInDepartment(info, numberDepartment);
        //Назначаем число для отбора сотрудников по зарплате больше/меньше salaryForSelectionEmployees
        double salaryForSelectionEmployees = 18_000;
        //Вызываем метод для "Получить в качестве параметра число и вывести:
        // Всех сотрудников с зп меньше числа (распечатать id, фио и зп в консоль);"
        Employee.findPersonsWithSalaryLessSalaryForSelectionEmployees(info, salaryForSelectionEmployees);
        //Вызываем метод для "Получить в качестве параметра число и вывести:
        //Всех сотрудников с зп больше (или равно) числа (распечатать id, фио и зп в консоль)."
        Employee.findPersonsWithSalaryMoreSalaryForSelectionEmployees(info, salaryForSelectionEmployees);


    }
}