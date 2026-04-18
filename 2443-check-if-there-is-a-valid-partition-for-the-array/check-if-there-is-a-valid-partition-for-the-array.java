class Solution {
    public boolean validPartition(int[] nums) {
        int n= nums.length;

        boolean[] dp= new boolean[n];

        for(int i=0; i<n; i++){

        /// check 3 cases if [x, x], [x, x, x] or [x, x+1, x+2] if true then valid b ut each partion should be true so check prev dp[i] is true or not 

        if(i>=1 && nums[i] == nums[i-1]){
            if(i==1 || dp[i-2]){
                dp[i]= true;
            }
        }

        if(i>=2 && nums[i] == nums[i-1] && nums[i-1]==nums[i-2]){
            if(i==2 || dp[i-3]){
                dp[i]= true;
            }
        }

        if(i>=2 && nums[i] == nums[i-1]+1 && nums[i-1]==nums[i-2]+1) {
            if(i==2 || dp[i-3]){
                dp[i]= true;
            }
        }
        }
        return dp[n-1];
    }
}