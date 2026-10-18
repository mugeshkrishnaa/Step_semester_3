abstract class Customer {
    double amount;

    Customer(double amount) {
        this.amount = amount;
    }

    abstract double calculate();
    abstract String getType();
}

class Student extends Customer {
    Student(double amount) {
        super(amount);
    }

    double calculate() {
        return amount * 0.90;
    }

    String getType() {
        return "STUDENT";
    }
}

class Staff extends Customer {
    Staff(double amount) {
        super(amount);
    }

    double calculate() {
        return amount * 0.95;
    }

    String getType() {
        return "STAFF";
    }
}

class Guest extends Customer {
    Guest(double amount) {
        super(amount);
    }

    double calculate() {
        return amount + 10;
    }

    String getType() {
        return "GUEST";
    }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Customer[] bills = {
            new Student(200),
            new Staff(300),
            new Guest(150)
        };

        double total = 0;

        for (Customer c : bills) {
            double finalAmount = c.calculate();
            System.out.printf("%s: %.2f%n",
                    c.getType(), finalAmount);
            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
