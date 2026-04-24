class Solution {
    public int minimumCoins(int[] prices) {
        int n = prices.length;

        int[] dp = new int[n + 1];

        dp[n] = 0;
        dp[n - 1] = prices[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            int minCoins = Integer.MAX_VALUE;

            for (int j = i + 1; j <= Math.min(2 * i + 2, n); j++) {
                minCoins = Math.min(minCoins, dp[j]);
            }

            dp[i] = prices[i] + minCoins;
        }

        return dp[0];
    }
}