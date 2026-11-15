
public class DiceThrowTally {
    static int[] diceSort(int[] rolls) {
        int[] count = new int[7];

        for (int roll : rolls) {
            count[roll]++;
        }

        System.out.print("Counts: ");
        for (int i = 1; i <= 6; i++) {
            System.out.print(i + ":" + count[i] + " ");
        }

        int[] result = new int[rolls.length];
        int index = 0;

        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j < count[i]; j++) {
                result[index++] = i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] rolls = {4, 1, 2, 4, 1, 4, 6};

        int[] result = diceSort(rolls);

        System.out.println("\nSorted:");
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }
}
