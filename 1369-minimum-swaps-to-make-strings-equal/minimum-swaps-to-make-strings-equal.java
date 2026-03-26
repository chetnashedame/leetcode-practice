class Solution {
    public int minimumSwap(String s1, String s2) {
        int xy = 0, yx = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == 'x' && s2.charAt(i) == 'y') {
                xy++;
            } else if (s1.charAt(i) == 'y' && s2.charAt(i) == 'x') {
                yx++;
            }
        }

        // If total mismatches is odd then impossible if xy is odd then yx should be odd only
        if ((xy + yx) % 2 != 0) return -1;
       
       //Pair same.... 1 swap  
        // Leftover mixed .... 2 swaps
        return (xy / 2) + (yx / 2) + (xy % 2) * 2;    //pair xy+pair yx+leftover (if leftover exist xy%2 handles it *2)
    }
}
  