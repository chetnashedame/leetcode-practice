class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first= startingPosition(nums, target);
        int last= endingPosition(nums, target);
        return new int[]{first, last};
    }
        private int startingPosition(int[]arr, int target){
            int l=0;
            int r=arr.length-1;
            int ans=-1;
            while(l<=r){
                int mid=l+(r-l)/2;
                if(arr[mid]==target){
                    ans=mid;
                    r=mid-1;
                }
                else if (arr[mid]<target){
                    l=mid+1;
                }
                else {
                    r=mid-1;
                }
            }
            return ans;

        }

        private int endingPosition(int[]arr, int target){
            int l=0;
            int r=arr.length-1;
            int ans=-1;
            while(l<=r){
                int mid=l+(r-l)/2;
                if(arr[mid]==target){
                    ans=mid;
                    l=mid+1;
                }
                else if (arr[mid]>target){
                    r=mid-1;
                }
                else {
                    l=mid+1;
                }
            }
            return ans;

        
    }
}