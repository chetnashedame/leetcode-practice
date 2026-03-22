class Solution {
    public int jump(int[] nums) {
        int minSteps=0;
        int curr=0;
        int end=0;

        for(int i=0; i<nums.length-1; i++){
            end=Math.max(end, i+nums[i]);

            if(i==curr){
            minSteps++;
            curr=end;
            }
        }
        return minSteps;
    
    }
}