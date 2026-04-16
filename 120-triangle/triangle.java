//as we know the last row we can use bottom up approch 

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n= triangle.size();
        int [] dp= new int [n];

        for(int j=0; j<n; j++){                   ///last row 
            dp[j]=triangle.get(n-1).get(j);
        }

        for(int i=n-2; i>=0; i--){                 ///bottom-up 
            for(int j=0; j<= i; j++){
                dp[j]=triangle.get(i).get(j)+ Math.min(dp[j], dp[j+1]);

            }
        }
        return dp[0];
    }
}