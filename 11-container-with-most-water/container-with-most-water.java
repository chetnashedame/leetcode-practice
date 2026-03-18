class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right =height.length-1;

        int area=0; 
        while(left<right){
            int distance=Math.min(height[left],height[right]);
            int width=right-left;

            area=Math.max(area, distance*width);

            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return area;
    }
}