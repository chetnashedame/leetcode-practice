///// recursion + memoization (top down approach) same as house 1 just need to add 2 cases and two dp states
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        // case 1: exclude last
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int case1 = solve(nums, 0, n - 2, dp1);

        // case 2: exclude first
        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        int case2 = solve(nums, 1, n - 1, dp2);

        return Math.max(case1, case2);
    }

    private int solve(int[] nums, int i, int end, int[] dp) {
        if (i > end) return 0;

        if (dp[i] != -1) return dp[i];

        int steal = nums[i] + solve(nums, i + 2, end, dp);
        int skip = solve(nums, i + 1, end, dp);

        return dp[i] = Math.max(steal, skip);
    }
}