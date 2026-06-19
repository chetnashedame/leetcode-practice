class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;

        //find pivot element
        int i=n-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }

        //find pivot's successor
       if(i>=0){
        int j=n-1;
        while(i>=0 && nums[j]<=nums[i]){
            j--;
        }
        //swap between pivot and succesor 
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
       }

       // reverse everything from pivot+1 to n-1
       int left=i+1;
       int right=n-1;
       while(left<right){
        int temp= nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
        left++;
        right--;
       }
    }
}