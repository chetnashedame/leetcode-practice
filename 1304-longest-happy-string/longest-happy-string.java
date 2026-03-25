class Solution {
    public String longestDiverseString(int a, int b, int c) {
      PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> y[0] -x[0]);
      if(a>0) pq.offer(new int []{a, 'a'});
      if (b>0) pq.offer(new int[]{b, 'b'});
      if (c>0) pq.offer(new int[]{c, 'c'});
    StringBuilder sb= new StringBuilder();

    while (!pq.isEmpty()) {
            int[] first = pq.poll();
            int count1 = first[0];
            char ch1 = (char) first[1];

            int len = sb.length();

            // If last two chars same as ch1 → cannot use
            if (len >= 2 && sb.charAt(len - 1) == ch1 && sb.charAt(len - 2) == ch1) {

                if (pq.isEmpty()) break;

                int[] second = pq.poll();
                int count2 = second[0];
                char ch2 = (char) second[1];

                sb.append(ch2);
                count2--;

                if (count2 > 0) pq.offer(new int[]{count2, ch2});
                pq.offer(first); // push first back

            } else {
                sb.append(ch1);
                count1--;

                if (count1 > 0) pq.offer(new int[]{count1, ch1});
            }
        }

        return sb.toString();

    }
}