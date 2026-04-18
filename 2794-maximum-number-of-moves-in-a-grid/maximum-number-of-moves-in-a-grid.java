class Solution {
    public int maxMoves(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;

        int [][] dp= new int [m][n];
        int maxMoves=0;

        for(int j=n-2; j>=0; j--){        //we can start from right to left
            for(int i=0; i<m; i++){

                int allowed=0;

                if(i>0 && grid[i-1][j+1] > grid[i][j]){
                    allowed=Math.max(allowed, 1+dp[i-1][j+1]);  //up right
                }

                if(grid[i][j+1] > grid[i][j]){
                    allowed=Math.max(allowed, 1+dp[i][j+1]);  // right
                }

                if(i<m-1 && grid[i+1][j+1] > grid[i][j]){
                    allowed=Math.max(allowed, 1+dp[i+1][j+1]);  //down  right
                }
            dp[i][j]=allowed;

            }
        }
        for(int i=0; i<m; i++){
            maxMoves=Math.max(maxMoves, dp[i][0]);
        }
        return maxMoves;
    }
}