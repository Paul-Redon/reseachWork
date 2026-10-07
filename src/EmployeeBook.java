public class EmployeeBook {
    private final Employee[] employees = new Employee[10];
    public void printAllEmployees() {
        System.out.println("~~ Список всех сотрудников ~~");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }
    public double calculateAverageSalary() {
        int sum = 0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
                count++;
            } else {
                break;
            }
        }
        return count == 0 ? 0 : (double) sum / count;
    }
    public void printTaxes(String type) {
        System.out.println("~~ Налоги (" + type + ") ~~");
        for (Employee employee : employees) {
            if (employee == null) break;
            double taxRate;
            switch (type) {
                case "PROPORTIONAL":
                    taxRate = 0.13;
                    break;
                case "PROGRESSIVE":
                    if (employee.getSalary() < 150) {
                        taxRate = 0.13;
                    } else if (employee.getSalary() < 350) {
                        taxRate = 0.17;
                    } else {
                        taxRate = 0.21;
                    }
                    break;
                default:
                    taxRate = 0.13;
            }
            double tax = employee.getSalary() * taxRate;
            System.out.printf("%s — налог: %.2f%n", employee.getFullName(), tax);
        }
    }
    public void indexSalaries(int department, int percent) {
        System.out.println("~~ Индексация отдела " + department + " на " + percent + "% ~~");
        for (Employee employee : employees) {
            if (employee == null) break;
            if (employee.getDepartment() != department) {
                continue;
            }
            int newSalary = employee.getSalary() + employee.getSalary() * percent / 100;
            employee.setSalary(newSalary);
            System.out.println(employee.getFullName() + " — новая зарплата: " + newSalary);
        }
    }
    public void findFirstByDepartmentAndSalary(int department, int minSalary) {
        System.out.println("~~ Первый сотрудник отдела " + department + " с зарплатой > " + minSalary + " ~~");
        int index = 0;
        for (Employee employee : employees) {
            if (employee == null) break;
            index++;
            if (employee.getDepartment() == department && employee.getSalary() > minSalary) {
                System.out.print("Порядковый номер: " + index + ", ");
                employee.printShortInfo();
                return;
            }
        }
        System.out.println("Сотрудник не найден");
    }
    public void findFirstNBySalary(int wage, int employeeNumber) {
        System.out.println("~~ Первые " + employeeNumber + " сотрудников с зарплатой < " + wage + " ~~");
        int found = 0;
        int index = 0;
        while (index < employees.length) {
            Employee employee = employees[index];
            index++;
            if (employee == null) break;
            if (employee.getSalary() < wage) {
                employee.printShortInfo();
                found++;
                if (found >= employeeNumber) break;
            }
        }
        if (found == 0) {
            System.out.println("Сотрудники не найдены");
        }
    }
    public boolean containsEmployee(Employee target) {
        if (target == null) return false;
        for (Employee employee : employees) {
            if (employee == null) break;
            if (employee.equals(target)) {
                return true;
            }
        }
        return false;
    }
    public boolean addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                return true;
            }
        }
        return false;
    }
    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee == null) break;
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
}