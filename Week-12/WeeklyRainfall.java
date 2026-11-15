import java.util.*;

public class WeeklyRainfall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] rain = new double[7];
        double total = 0;
        int dry = 0, wettest = 0;

        for (int i = 0; i < 7; i++) {
            rain[i] = sc.nextDouble();
            total += rain[i];

            if (rain[i] == 0)
                dry++;

            if (rain[i] > rain[wettest])
                wettest = i;
        }

        System.out.print("Rainfall (mm): ");

        for (int i = 0; i < 7; i++)
            System.out.printf("%.1f ", rain[i]);

        System.out.println();

        System.out.printf("Total Rainfall: %.1f mm%n", total);
        System.out.printf("Average Rainfall: %.2f mm%n", total / 7);
        System.out.printf(
            "Wettest Day: Day %d (%.1f mm)%n",
            wettest + 1, rain[wettest]
        );

        System.out.println("Total Dry Days: " + dry);
    }
}
