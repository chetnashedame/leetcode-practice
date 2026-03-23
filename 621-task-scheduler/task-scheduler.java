class Solution {
    public int leastInterval(char[] tasks, int n) {

        // Step 1: frequency count 
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: max heap (store frequencies)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int freq : map.values()) {
            pq.offer(freq);
        }

        int time = 0;

        // Step 3: process until all tasks done
        while (!pq.isEmpty()) {

            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;

            // Step 4: fill one cycle
            while (cycle > 0 && !pq.isEmpty()) {
                int freq = pq.poll();   // take most frequent task

                if (freq - 1 > 0) {
                    temp.add(freq - 1); // remaining work
                }

                time++;
                cycle--;
            }

            // Step 5: push remaining tasks back
            for (int f : temp) {
                pq.offer(f);
            }

            // Step 6: add idle time if needed
            if (!pq.isEmpty()) {
                time += cycle;
            }
        }

        return time;
    }
}
    