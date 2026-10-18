abstract class Payment {
    double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    abstract double calculate();

    abstract String getType();
}

class Card extends Payment {
    Card(double amount) {
        super(amount);
    }

    double calculate() {
        return amount * 1.02;
    }

    String getType() {
        return "CARD";
    }
}

class Wallet extends Payment {
    Wallet(double amount) {
        super(amount);
    }

    double calculate() {
        return amount * 1.01;
    }

    String getType() {
        return "WALLET";
    }
}

class BankTransfer extends Payment {
    BankTransfer(double amount) {
        super(amount);
    }

    double calculate() {
        return amount;
    }

    String getType() {
        return "BANKTRANSFER";
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Payment[] payments = {
            new Card(1000),
            new Wallet(500),
            new BankTransfer(2000)
        };

        double total = 0;

        for (Payment p : payments) {
            double fee = p.calculate();
            System.out.printf("%s: %.2f%n", p.getType(), fee);
            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
