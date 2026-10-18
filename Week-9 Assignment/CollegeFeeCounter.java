import java.util.*;

interface BusUser {
}

abstract class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double getTuition();

    double getFee() {
        double transport = (this instanceof BusUser) ? 12000 : 0;
        return getTuition() + transport;
    }
}

class DayScholar extends Student implements BusUser {
    DayScholar(String name) {
        super(name);
    }

    double getTuition() {
        return 40000;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double getTuition() {
        return 40000 + 60000;
    }
}

class Scholar extends Student implements BusUser {
    Scholar(String name) {
        super(name);
    }

    double getTuition() {
        return 20000;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();
            Student s;

            if (type.equals("DAY_SCHOLAR"))
                s = new DayScholar(name);
            else if (type.equals("HOSTELLER"))
                s = new Hosteller(name);
            else
                s = new Scholar(name);

            double fee = s.getFee();
            System.out.printf("%s: %.2f%n", name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}
