class Solution {
    long[][] dp;
    int n;

    public long maxAlternatingSum(int[] nums) {
        n = nums.length;
        dp = new long[n][2];

        // initialize with -1 (means uncomputed)
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        // isEven = 1 → next pick is treated as +
        // isEven = 0 → next pick is treated as -
        return solve(0, nums, 1);
    }

    private long solve(int idx, int[] nums, int isEven) {
        if (idx >= n) return 0;

        if (dp[idx][isEven] != -1) {
            return dp[idx][isEven];
        }

        // option 1: skip current element
        long skip = solve(idx + 1, nums, isEven);

        // option 2: take current element
        long val = nums[idx];
        if (isEven == 0) {
            val = -val;
        }

        long take = val + solve(idx + 1, nums, 1 - isEven);

        return dp[idx][isEven] = Math.max(skip, take);
    }
}