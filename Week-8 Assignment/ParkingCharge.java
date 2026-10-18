abstract class Vehicle {
    int hours;

    Vehicle(int hours) {
        this.hours = hours;
    }

    abstract double calculate();
    abstract String getType();
}

class Bike extends Vehicle {
    Bike(int hours) {
        super(hours);
    }

    double calculate() {
        return hours * 10;
    }

    String getType() {
        return "BIKE";
    }
}

class Car extends Vehicle {
    Car(int hours) {
        super(hours);
    }

    double calculate() {
        return 30 + (hours - 1) * 20;
    }

    String getType() {
        return "CAR";
    }
}

class Truck extends Vehicle {
    Truck(int hours) {
        super(hours);
    }

    double calculate() {
        return Math.max(100, hours * 50);
    }

    String getType() {
        return "TRUCK";
    }
}

public class ParkingCharge {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Bike(3),
            new Car(4),
            new Truck(1),
            new Car(1)
        };

        double total = 0;

        for (Vehicle v : vehicles) {
            double charge = v.calculate();
            System.out.printf("%s: %.2f%n",
                    v.getType(), charge);
            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
