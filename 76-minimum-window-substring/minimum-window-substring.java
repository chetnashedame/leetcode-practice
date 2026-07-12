class Solution {
    public String minWindow(String s, String t) {
        if(s.isEmpty() || t.isEmpty()) return "";

        HashMap<Character, Integer> need= new HashMap<>();
        for(char c : t.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int required= need.size();
        int formed=0;
        HashMap<Character, Integer> winCount=new HashMap<>();

        int left=0, right=0;
        int minLen=Integer.MAX_VALUE, minStart=0;

        while(right< s.length()){
            char c = s.charAt(right);
            winCount.put(c, winCount.getOrDefault(c, 0) + 1);

            if(need.containsKey(c) && winCount.get(c).intValue()==need.get(c)){
                formed++;
            }

            while(left<=right && formed==required){
                if(right-left+1 < minLen){
                    minLen= right-left+1;
                    minStart=left;
                }

                char leftChar=s.charAt(left);
                winCount.put(leftChar, winCount.get(leftChar) -1);
                if(need.containsKey(leftChar) && winCount.get(leftChar) < need.get(leftChar)){
                    formed--;
                }
                left++;

            }
            right++;
        } return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart+minLen);
    }
}