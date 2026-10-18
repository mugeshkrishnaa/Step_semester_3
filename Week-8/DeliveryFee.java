abstract class Delivery {
    double weight, distance;

    Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    abstract double calculateFee();

    abstract String getType();
}

class Standard extends Delivery {
    Standard(double w, double d) {
        super(w, d);
    }

    double calculateFee() {
        return 5 + 0.5 * weight + 0.1 * distance;
    }

    String getType() {
        return "STANDARD";
    }
}

class Express extends Delivery {
    Express(double w, double d) {
        super(w, d);
    }

    double calculateFee() {
        return 15 + weight + 0.2 * distance;
    }

    String getType() {
        return "EXPRESS";
    }
}

class International extends Delivery {
    double customsFee;

    International(double w, double d, double c) {
        super(w, d);
        customsFee = c;
    }

    double calculateFee() {
        return 25 + 2 * weight + 0.5 * distance + customsFee;
    }

    String getType() {
        return "INTERNATIONAL";
    }
}

public class DeliveryFee {
    public static void main(String[] args) {
        Delivery[] deliveries = {
            new Standard(10, 50),
            new Express(5, 20),
            new International(20, 100, 30)
        };

        double total = 0;

        for (Delivery d : deliveries) {
            double fee = d.calculateFee();
            System.out.printf("%s: %.2f%n", d.getType(), fee);
            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
