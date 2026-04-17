class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];

        // base cases
        for (int i = 0; i <= n; i++) {
            dp[i][m] = n - i; // delete all remaining
        }

        for (int j = 0; j <= m; j++) {
            dp[n][j] = m - j; // insert all remaining
        }

        // fill bottom-up
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {

                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = 1 + Math.min(
                        dp[i + 1][j],     // delete
                        Math.min(
                            dp[i][j + 1], // insert
                            dp[i + 1][j + 1] // replace
                        )
                    );
                }

            }
        }

        return dp[0][0];
    }
}