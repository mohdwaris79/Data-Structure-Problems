public class CoinChange {

    public int count(int coins[], int sum) {
        int n = coins.length;
        int dp[][] = new int[n + 1][sum + 1];

        // Base case: sum = 0 → 1 way (choose nothing)
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }

        // Base case: no coins but sum > 0 → 0 ways
        for (int j = 1; j < sum + 1; j++) {
            dp[0][j] = 0;
        }

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();

        int coins[] = {1, 2, 3};
        int sum = 4;

        int ways = cc.count(coins, sum);

        System.out.println("Number of ways to make sum " + sum + " = " + ways);
    }
}
