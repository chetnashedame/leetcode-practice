class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length;
        int maxi = 0;
        for (int x : nums) maxi = Math.max(maxi, x);

        // freq[i] = count of elements equal to i
        int[] freq = new int[maxi + 1];
        for (int x : nums) freq[x]++;

        // Convert to prefix sum
        for (int i = 1; i <= maxi; i++) freq[i] += freq[i - 1];

        int ans = 1;

        // Iterate over every possible target value (not just values in nums)
        // because optimal target may not exist in nums
        // e.g. nums = [88, 53], k = 27 → answer = 2 (target could be 60-80 range)
        for (int ele = 1; ele <= maxi; ele++) {
            int currFreq = freq[ele] - freq[ele - 1]; // actual count of 'ele' in nums

            int r = Math.min(maxi, ele + k);
            int l = Math.max(0, ele - k);

            // Count of all elements in [l, r] using prefix sum
            long totalCount = freq[r] - (l > 0 ? freq[l - 1] : 0);

            int requiredOps = (int)(totalCount - currFreq); // ops needed to bring others to ele
            int valid = Math.min(numOperations, requiredOps);

            ans = Math.max(ans, currFreq + valid);
        }

        return ans;
    }
}