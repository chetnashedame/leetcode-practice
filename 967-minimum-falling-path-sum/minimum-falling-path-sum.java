class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n= matrix.length;

        int[][] dp= new int[n][n];

        //first row will be same 
        for(int j=0; j<n; j++){
            dp[0][j]=matrix[0][j];
        }

        //fill each row by row from 2nd row

        for(int i=1; i<n; i++){
            for(int j=0; j<n; j++){

                int down = dp[i-1][j];

                int downLeft = (j>0) ? dp[i-1][j-1] : Integer.MAX_VALUE;

                int downRight= (j < n-1)? dp[i-1][j+1] : Integer.MAX_VALUE;

            dp[i][j]= matrix[i][j] + Math.min(down, Math.min(downLeft, downRight));

            }
        }
        //ans will be min value at last row go to each column

        int ans=Integer.MAX_VALUE;
        for(int j=0; j<n; j++){
            ans=Math.min(ans, dp[n-1][j]);
        }
        
        return ans;
    }
    
}