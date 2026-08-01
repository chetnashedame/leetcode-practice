class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set= new HashSet<>();  // set will remove duplicates

        for(int i=0; i+k <=s.length(); i++){ ///we don't want codes to be out og s.length()
           set.add(s.substring(i, i+k));
        }
        return set.size()==(1<<k); //1<<k will compute total no. of binarycodes of length k. << shifts left by 1 all the remaining values will be 0 
        //for e.g. 0001 -> 0010 -> 0100 -> 1000 thus, all the binary codes will be generated.
    }
}