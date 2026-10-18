abstract class Room {
    int units;

    Room(int units) {
        this.units = units;
    }

    abstract double calculate();
    abstract String getType();
}

class Single extends Room {
    Single(int units) {
        super(units);
    }

    double calculate() {
        return units * 8;
    }

    String getType() {
        return "SINGLE";
    }
}

class Shared extends Room {
    int occupants;

    Shared(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    double calculate() {
        return (units * 6.0) / occupants;
    }

    String getType() {
        return "SHARED";
    }
}

class AC extends Room {
    AC(int units) {
        super(units);
    }

    double calculate() {
        return units * 10 + 200;
    }

    String getType() {
        return "AC";
    }
}

public class ElectricityBill {
    public static void main(String[] args) {
        Room[] rooms = {
            new Single(120),
            new Shared(150, 3),
            new AC(100)
        };

        double total = 0;

        for (Room r : rooms) {
            double bill = r.calculate();
            System.out.printf("%s: %.2f%n",
                    r.getType(), bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
