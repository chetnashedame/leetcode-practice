class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        
        int maxTime = 0;

        // Ants going left
        for (int pos : left) {
            maxTime = Math.max(maxTime, pos);
        }

        // Ants going right
        for (int pos : right) {
            maxTime = Math.max(maxTime, n - pos);
        }

        return maxTime;
    }
}
    