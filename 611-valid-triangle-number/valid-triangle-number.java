class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int count = 0;

        // fix largest side so upto k=2 cause we know larger will be upto k=2only
        for (int k = n - 1; k >= 2; k--) {

            int i = 0;
            int j = k - 1; 

            // two pointer
            while (i < j) {

                // Step 4: valid triangle
                if (nums[i] + nums[j] > nums[k]) {
                                                       // nums[i+1]+...>
                    // all between i and j are valid bec  nums[i]+nums[j]> nums[k]
                    count += (j - i);

                    j--; // move left

                } else {
                    i++; // need bigger value
                }
            }
        }

        return count;
    }
}