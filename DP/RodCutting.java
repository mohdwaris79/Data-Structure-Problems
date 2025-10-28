public class RodCutting {
    

    public int cutRod(int[] price) {
        int n = price.length;
        int[] length = new int[n];

        
        for (int i = 0; i < n; i++) {
            length[i] = i + 1;
        }

        return helper(length, price, n, n);
    }

    public int helper(int length[], int price[], int n, int rod) {
        int dp[][] = new int[n + 1][rod + 1];

      
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= rod; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= rod; j++) {
                if (length[i - 1] <= j) {
                    dp[i][j] = Math.max(
                        price[i - 1] + dp[i][j - length[i - 1]], 
                        dp[i - 1][j] 
                    );
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][rod];
    }

    public static void main(String[] args) {
        RodCutting sol = new  RodCutting();

        // Example price array (price[i] = price of rod of length i+1)
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};

        int maxProfit = sol.cutRod(price);

        System.out.println("Maximum profit: " + maxProfit);
    }
}

