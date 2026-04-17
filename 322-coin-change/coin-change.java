/////Unbounded Knapsack (Min coins)
///You can use same coin unlimited times
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        // fill with large value (we are taking amount + 1 as infinite value just to get proper min values and replace amont +1 later with actual needed coins)
        Arrays.fill(dp, amount + 1);

        dp[0] = 0; // base case

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {

                if (i - coin >= 0) {        ///this condition checks if coins needed are not neg values 
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }

            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}