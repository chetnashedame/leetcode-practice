////// recursion+memoization approach (Top-down)
class Solution {
    int dp[];
    public int rob(int[] nums) {
        int n= nums.length;
        dp=new int[n];

        Arrays.fill(dp, -1);
        return solve(nums, 0);
    }
    
    private int solve(int []nums, int i){
        if (i>=nums.length) return 0;

        if(dp[i]!=-1){
            return dp[i];
        }

        int steal=nums[i]+solve(nums, i+2);
        int skip =solve(nums, i+1);

        return dp[i]=Math.max(steal, skip);
    }
}