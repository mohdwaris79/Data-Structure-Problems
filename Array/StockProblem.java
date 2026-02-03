public class StockProblem {

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE; 
        int maxProfit = 0;                

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;         // update min price
            } else {
                int profit = price - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;   // update max profit
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices1 = {7, 10, 1, 3, 6, 9, 2};
        int[] prices2 = {7, 6, 4, 3, 1};
        int[] prices3 = {1, 3, 6, 9, 11};

        System.out.println(maxProfit(prices1)); // 8
        System.out.println(maxProfit(prices2)); // 0
        System.out.println(maxProfit(prices3)); // 10
    }
}
