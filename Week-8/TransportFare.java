abstract class Transport {
    double distance;

    Transport(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();

    abstract String getType();
}

class Bus extends Transport {
    Bus(double d) {
        super(d);
    }

    double calculateFare() {
        return Math.min(2 + 0.1 * distance, 10);
    }

    String getType() {
        return "BUS";
    }
}

class Train extends Transport {
    Train(double d) {
        super(d);
    }

    double calculateFare() {
        return 3 + 0.15 * distance;
    }

    String getType() {
        return "TRAIN";
    }
}

class Metro extends Transport {
    double factor;

    Metro(double d, double factor) {
        super(d);
        this.factor = factor;
    }

    double calculateFare() {
        return (1.5 + 0.2 * distance) * factor;
    }

    String getType() {
        return "METRO";
    }
}

public class TransportFare {
    public static void main(String[] args) {
        Transport[] journeys = {
            new Bus(15),
            new Train(50),
            new Metro(10, 1.5)
        };

        double total = 0;

        for (Transport t : journeys) {
            double fare = t.calculateFare();
            System.out.printf("%s: %.2f%n", t.getType(), fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
