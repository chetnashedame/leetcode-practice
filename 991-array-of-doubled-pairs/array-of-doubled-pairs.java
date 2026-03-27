class Solution {
    public boolean canReorderDoubled(int[] arr) {

        // Step 1: frequency map
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: sort by absolute value
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(nums, (a, b) -> Integer.compare(Math.abs(a), Math.abs(b)));

        // Step 3: greedy pairing
        for (int x : nums) {

            if (map.get(x) == 0) continue;

            int doubleVal = 2 * x;

            if (map.getOrDefault(doubleVal, 0) <= 0) {
                return false;
            }

            // use both(if pair exists then remove both freq 0)
            map.put(x, map.get(x) - 1);
            map.put(doubleVal, map.get(doubleVal) - 1);
        }

        return true;
    }
}