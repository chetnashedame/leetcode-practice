class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups= new HashMap<>();

        for(String s:strs){
            int []count= new int[26];
            for(char c: s.toCharArray()){
                count[c - 'a']++;
            }

        StringBuilder key =new StringBuilder();
        for(int c: count){
            key.append(c).append('#');
        }

        groups.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(s);

        }
        return new ArrayList<>(groups.values());
    }
}