class Solution {
    public int candy(int[] ratings) {

        int n = ratings.length;

        int[] left = new int[n];   // candies based on left neighbor
        int[] right = new int[n];  // candies based on right neighbor

        // Step 1: initialize → everyone gets at least 1
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        // Step 2: left → right pass
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }

        // Step 3: right → left pass
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }

        // Step 4: take max from both sides
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.max(left[i], right[i]);
        }

        return ans;
    }
}