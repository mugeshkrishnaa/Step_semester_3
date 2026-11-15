import java.util.*;

class Staff {
    String name;
    double baseSalary;

    Staff(String name, double salary) {
        this.name = name;
        baseSalary = salary;
    }

    double getBonus() {
        return 0;
    }

    String getType() {
        return "Staff";
    }
}

class Teacher extends Staff {
    Teacher(String n, double s) {
        super(n, s);
    }

    double getBonus() {
        return 5000;
    }

    String getType() {
        return "Teacher";
    }
}

class LabAssistant extends Staff {
    LabAssistant(String n, double s) {
        super(n, s);
    }

    double getBonus() {
        return 2000;
    }

    String getType() {
        return "LabAssistant";
    }
}

public class StaffSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Staff[] arr = new Staff[n];
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            if (type.equals("Teacher"))
                arr[i] = new Teacher(name, salary);
            else if (type.equals("LabAssistant"))
                arr[i] = new LabAssistant(name, salary);
            else
                arr[i] = new Staff(name, salary);
        }

        for (Staff s : arr) {
            double bonus = s.getBonus();
            double total = s.baseSalary + bonus;
            grandTotal += total;

            System.out.printf(
                "%s (%s): base %.1f, bonus %.1f, total %.1f%n",
                s.name, s.getType(), s.baseSalary, bonus, total
            );
        }

        System.out.printf("Grand Total Salary: %.1f%n", grandTotal);
    }
}
