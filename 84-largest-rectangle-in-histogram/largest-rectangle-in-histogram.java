class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack= new Stack<>();
        int maxArea=0;

        for(int i=0; i<=heights.length; i++){
            int curr = (i == heights.length) ? 0 : heights[i];

            while (!stack.isEmpty() && curr < heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                int width = i - left - 1;

                maxArea = Math.max(maxArea, h * width);
             }

            stack.push(i);
        }

        return maxArea;
        
    }
}