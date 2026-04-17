class Solution {
    public int rob(int[] nums) {
       int n= nums.length;

       if(n==1) return nums[0];

       return Math.max(skipFirstOrLast(nums, 0, n-2), skipFirstOrLast(nums, 1, n-1));
    }

    private int skipFirstOrLast(int [] nums, int first, int last){
        int prev2=0;
        int prev1=0;

        for(int i=first; i<=last; i++){
            int curr= Math.max(prev1, nums[i]+prev2);  
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}