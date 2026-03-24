class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int MOD = 1_000_000_007;

        // Step 1: pair efficiency & speed
        int[][] engineers = new int[n][2];
        for (int i = 0; i < n; i++) {
            engineers[i][0] = efficiency[i];
            engineers[i][1] = speed[i];
        }

        // Step 2: sort by efficiency DESC
        Arrays.sort(engineers, (a, b) -> b[0] - a[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long speedSum = 0, maxPerf = 0;

        // Step 3: iterate
        for (int[] eng : engineers) {
            int eff = eng[0];
            int spd = eng[1];

            minHeap.offer(spd);
            speedSum += spd;

            // Step 4: maintain size k
            if (minHeap.size() > k) {
                speedSum -= minHeap.poll();
            }

            // Step 5: calculate performance
            maxPerf = Math.max(maxPerf, speedSum * eff);
        }

        return (int)(maxPerf % MOD);
    }
}