class Solution {
    public int minOperations(int n) {
        int steps = 0;

        while (n > 0) {
            int p = Integer.highestOneBit(n);

            if (n == p) {
                n -= p;
            } else {
                int next = p << 1;
                if (next - n < n - p) {
                    n = next - n;
                } else {
                    n -= p;
                }
            }

            steps++;
        }

        return steps;
    }
}