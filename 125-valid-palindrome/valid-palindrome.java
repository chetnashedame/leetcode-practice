class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()) return true;
        int right=s.length()-1;
        int left=0;
        while(left<right){
            while(left<=right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(left<=right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if(left<=right && Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
                return false; 
            }
            left++;
            right--;
        }
        return true;
    }
}