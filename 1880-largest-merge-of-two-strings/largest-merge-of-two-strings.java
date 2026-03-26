class Solution {
    public String largestMerge(String word1, String word2) {
        StringBuilder res = new StringBuilder();

        int i = 0, j = 0;

        while (i < word1.length() && j < word2.length()) {
            if (word1.substring(i).compareTo(word2.substring(j)) > 0) {
                res.append(word1.charAt(i++));
            } else {
                res.append(word2.charAt(j++));
            }
        }

        while (i < word1.length()) res.append(word1.charAt(i++));
        while (j < word2.length()) res.append(word2.charAt(j++));

        return res.toString();
    }
}