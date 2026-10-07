public class Main {
    public static void main(String[] args) {
        EmployeeBook book = new EmployeeBook();
        System.out.println("~~ Добавление сотрудников ~~");
        System.out.println("Добавлен: " + book.addEmployee(new Employee("Иванов Иван Иванович", 1, 100)));
        System.out.println("Добавлен: " + book.addEmployee(new Employee("Петров Петр Петрович", 2, 200)));
        System.out.println("Добавлен: " + book.addEmployee(new Employee("Сидоров Сидор Сидорович", 3, 300)));
        System.out.println("Добавлен: " + book.addEmployee(new Employee("Кузнецов Алексей Иванович", 1, 150)));
        System.out.println("Добавлен: " + book.addEmployee(new Employee("Смирнова Анна Сергеевна", 4, 250)));
        System.out.println("Добавлен: " + book.addEmployee(new Employee("Волков Дмитрий Олегович", 2, 180)));
        System.out.println("Добавлен: " + book.addEmployee(new Employee("Морозова Елена Павловна", 5, 400)));
        System.out.println("Добавлен: " + book.addEmployee(new Employee("Новиков Сергей Иванович", 3, 350)));
        System.out.println("Добавлен: " + book.addEmployee(new Employee("Фёдорова Ольга Дмитриевна", 4, 120)));
        System.out.println("Добавлен: " + book.addEmployee(new Employee("Егоров Никита Андреевич", 5, 450)));
        System.out.println("Добавлен (11-й): " + book.addEmployee(new Employee("Лишний Сотрудник", 1, 500)));
        System.out.println();
        book.printAllEmployees();
        System.out.println("~~ Средняя зарплата ~~");
        System.out.printf("Средняя зарплата: %.2f%n", book.calculateAverageSalary());
        System.out.println();
        book.printTaxes("PROPORTIONAL");
        System.out.println();
        book.printTaxes("PROGRESSIVE");
        System.out.println();
        book.indexSalaries(1, 10);
        System.out.println();
        book.findFirstByDepartmentAndSalary(2, 150);
        System.out.println();
        book.findFirstNBySalary(200, 3);
        System.out.println("~~ Проверка наличия сотрудника ~~");
        Employee test1 = new Employee("Тест", 1, 200);
        Employee test2 = new Employee("Тест", 1, 999);
        System.out.println("Сотрудник с зарплатой 200 найден: " + book.containsEmployee(test1));
        System.out.println("Сотрудник с зарплатой 999 найден: " + book.containsEmployee(test2));
        System.out.println("~~ Поиск по id ~~");
        Employee found = book.getEmployeeById(3);
        if (found != null) {
            System.out.println("Найден: " + found);
        } else {
            System.out.println("Сотрудник с id=3 не найден");
        }
    }
}