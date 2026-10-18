import java.util.*;

interface NightService {
}

abstract class Cab {
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRate();

    double getFare(String time) {
        if (time.equals("NIGHT") && !(this instanceof NightService))
            return -1;

        double fare = Math.max(km * getRate(), 100);

        if (time.equals("NIGHT"))
            fare *= 1.20;

        return fare;
    }
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    double getRate() {
        return 10;
    }
}

class Sedan extends Cab implements NightService {
    Sedan(double km) {
        super(km);
    }

    double getRate() {
        return 14;
    }
}

class SUV extends Cab implements NightService {
    SUV(double km) {
        super(km);
    }

    double getRate() {
        return 18;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double km = sc.nextDouble();
            String time = sc.next().toUpperCase();
            Cab c;

            if (type.equals("MINI"))
                c = new Mini(km);
            else if (type.equals("SEDAN"))
                c = new Sedan(km);
            else
                c = new SUV(km);

            double fare = c.getFare(time);

            if (fare == -1) {
                System.out.println(type + ": night service not available");
            } else {
                System.out.printf("%s: %.2f%n", type, fare);
                total += fare;
            }
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
