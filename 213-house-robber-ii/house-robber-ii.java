///// bottoms up approch +memoization
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        // Case 1- include first, exclude last (0 → n-2)
        int[] t = new int[n + 1];
        t[0] = 0;

        for (int i = 1; i <= n - 1; i++) {
            t[i] = Math.max(
                t[i - 1],
                nums[i - 1] + (i - 2 >= 0 ? t[i - 2] : 0)
            );
        }
        int result1 = t[n - 1];

        // Case 2- exclude first, include last (1 → n-1)
        t = new int[n + 1]; // reinitialize (Java doesn't have clear like vector)
        t[0] = 0;
        t[1] = 0;

        for (int i = 2; i <= n; i++) {
            t[i] = Math.max(
                t[i - 1],
                nums[i - 1] + (i - 2 >= 0 ? t[i - 2] : 0)  ///to avoid out of bound situation
            );
        }
        int result2 = t[n];

        return Math.max(result1, result2);
    }
}