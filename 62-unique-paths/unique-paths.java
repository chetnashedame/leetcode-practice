class Solution {
    public int uniquePaths(int m, int n) {
        int []dp=new int [n];

        Arrays.fill(dp, 1);  ///first row fill with 1's 

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[j]= dp[j]+dp[j-1];     //dp[j] --no. of ways from top & dp[j-1] for no. of ways from left
            }
        }
        return dp[n-1];
    }
}