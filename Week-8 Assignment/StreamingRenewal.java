import java.time.LocalDate;

abstract class Plan {
    String name;
    LocalDate startDate;

    Plan(String name, String startDate) {
        this.name = name;
        this.startDate = LocalDate.parse(startDate);
    }

    abstract int getDays();

    void printRenewalDate() {
        LocalDate renewalDate = startDate.plusDays(getDays());
        System.out.println(name + ": " + renewalDate);
    }
}

class Basic extends Plan {
    Basic(String name, String date) {
        super(name, date);
    }

    int getDays() {
        return 30;
    }
}

class Standard extends Plan {
    Standard(String name, String date) {
        super(name, date);
    }

    int getDays() {
        return 90;
    }
}

class Premium extends Plan {
    Premium(String name, String date) {
        super(name, date);
    }

    int getDays() {
        return 365;
    }
}

public class StreamingRenewal {
    public static void main(String[] args) {
        Plan[] plans = {
            new Basic("Asha", "2024-01-15"),
            new Standard("Ravi", "2024-02-01"),
            new Premium("Neha", "2024-03-10"),
            new Basic("Kiran", "2024-12-20")
        };

        for (Plan p : plans) {
            p.printRenewalDate();
        }
    }
}
