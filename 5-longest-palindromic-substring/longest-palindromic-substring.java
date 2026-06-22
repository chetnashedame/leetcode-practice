class Solution {
    public String longestPalindrome(String s) {
        if(s==null || s.length()<1) return "";

        int start=0, end=0;   ///to keep current longest count of substring

        for(int i=0; i<s.length(); i++){
            int []odd= expand(s,i,i);
            int []even = expand(s,i,i+1);

            if(odd[1]-odd[0]> end- start){
                start=odd[0]; end=odd[1];
            }

            if(even[1]-even [0] > end -start){
                start=even[0]; end=even[1];
            }
        }
        return s.substring(start,end+1);
    }
    private int[] expand(String s, int l, int r){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return new int[]{l+1,r-1};
    }
}