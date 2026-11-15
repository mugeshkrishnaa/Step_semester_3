public class BestSingleTradeProfit {

    static int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;

        for (int price : prices) {
            if (price < min)
                min = price;

            if (price - min > profit)
                profit = price - min;
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] a = {7, 1, 5, 3, 6, 4};
        int[] b = {7, 6, 4, 3, 1};

        System.out.println(maxProfit(a));
        System.out.println(maxProfit(b));
    }
}
