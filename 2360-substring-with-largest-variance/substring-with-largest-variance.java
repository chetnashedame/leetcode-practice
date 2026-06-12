class Solution {
    public int largestVariance(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;

        int globalMax = 0;

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                // skip same char or chars not present in string
                if (i == j || count[i] == 0 || count[j] == 0) continue;

                char major = (char) ('a' + i);
                char minor = (char) ('a' + j);

                int majorCount = 0, minorCount = 0;
                boolean prevMinor = false;

                for (char c : s.toCharArray()) {
                    if (c == major) majorCount++;
                    if (c == minor) minorCount++;

                    // Case 1: minor IS in current window → valid variance
                    if (minorCount > 0) {
                        globalMax = Math.max(globalMax, majorCount - minorCount);
                    }
                    // Case 2: no minor in window BUT last window ended on minor
                    // borrow that minor → use majorCount - 1
                    else if (prevMinor) {
                        globalMax = Math.max(globalMax, majorCount - 1);
                    }

                    // Kadane reset: minor is dominating, start fresh
                    if (majorCount - minorCount < 0) {
                        majorCount = 0;
                        minorCount = 0;
                        prevMinor = true; // remember: minor closed this window
                    }
                }
            }
        }

        return globalMax;
    }
}