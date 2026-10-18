abstract class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    abstract double calculateBonus();
}

class FullTime extends Employee {
    FullTime(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return salary * 0.10;
    }
}

class PartTime extends Employee {
    PartTime(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return salary * 0.05;
    }
}

class Intern extends Employee {
    Intern(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return 2000;
    }
}

public class FestivalBonus {
    public static void main(String[] args) {
        Employee[] employees = {
            new FullTime("Asha", 50000),
            new PartTime("Ravi", 30000),
            new Intern("Neha", 15000)
        };

        double total = 0;

        for (Employee e : employees) {
            double bonus = e.calculateBonus();
            System.out.printf("%s: %.2f%n", e.name, bonus);
            total += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", total);
    }
}
