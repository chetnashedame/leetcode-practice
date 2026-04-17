class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];

        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {               ///bottom up

                if (word1.charAt(i) == word2.charAt(j)) {      
                    dp[i][j] = 1 + dp[i + 1][j + 1];         //if same take it
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);//if not same remove
                }

            }
        }

        int lcs =dp[0][0];

        return (n-lcs) +(m-lcs);     //remaining part is the amount of steps reqd  
    }
}