class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;

        int[] nge = new int[2 * n];
        Arrays.fill(nge, -1);

        Stack<Integer> st = new Stack<>(); // store indices

        for (int i = 0; i < 2 * n; i++) {
            while (!st.isEmpty() && nums[i % n] > nums[st.peek() % n]) {
                nge[st.peek()] = nums[i % n];
                st.pop();
            }
            st.push(i);
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = nge[i];
        }

        return ans;
    }
}