class Solution {
    public int maxSubArray(int[] nums) {
        int currSum=nums[0];
        int maxSum=nums[0];
        for(int right=1; right<nums.length; right++){
            currSum=Math.max(nums[right], currSum + nums[right]);
            maxSum=Math.max(currSum, maxSum);
        }
       return maxSum;
    }
}