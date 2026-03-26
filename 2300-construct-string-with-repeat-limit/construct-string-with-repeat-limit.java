class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {

        // Count frequency
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++; // count each character
        }

        // Max Heap (store char index + freq)
        // syntax: (a, b) -> b[0] - a[0] → max heap by character
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );

        // add all characters into heap
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(new int[]{i, freq[i]}); // {charIndex, count}
            }
        }

        StringBuilder sb = new StringBuilder();

        // Process heap
        while (!pq.isEmpty()) {

            int[] first = pq.poll(); // get largest char
            int ch1 = first[0];
            int count1 = first[1];

            // Use up to repeatLimit
            int use = Math.min(count1, repeatLimit);

            // append character 'use' times
            for (int i = 0; i < use; i++) {
                sb.append((char)(ch1 + 'a'));
            }

            count1 -= use; // reduce remaining count

            // If still remaining then need breaker
            if (count1 > 0) {

                if (pq.isEmpty()) break; // no smaller char thennn stop

                int[] second = pq.poll(); // next largest char
                int ch2 = second[0];
                int count2 = second[1];

                sb.append((char)(ch2 + 'a')); // add breaker
                count2--;

                // push back if still available
                if (count2 > 0) pq.offer(new int[]{ch2, count2});
                pq.offer(new int[]{ch1, count1});
            }
        }

        return sb.toString();
    }
}