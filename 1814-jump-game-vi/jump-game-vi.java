class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;

        Deque<Integer> dq = new ArrayDeque<>();
        dq.offerLast(0);

        int[] dp = new int[n];
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {

            // 1. Remove out-of-window indices
            if (dq.peekFirst() < i - k) {
                dq.pollFirst();
            }

            // 2. Take max from deque front
            dp[i] = dp[dq.peekFirst()] + nums[i];

            // 3. Maintain decreasing dp in deque
            while (!dq.isEmpty() && dp[dq.peekLast()] < dp[i]) {
                dq.pollLast();
            }

            // 4. Add current index
            dq.offerLast(i);
        }

        return dp[n - 1];
    }
}
   