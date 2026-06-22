class Solution {
    public int findDuplicate(int[] nums) {
        int slow=0, fast=0;

        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        while(slow!=fast);

        int finder=0;
        while(finder!=slow){
            slow=nums[slow];
            finder=nums[finder];
        }
        return finder;
    }
}