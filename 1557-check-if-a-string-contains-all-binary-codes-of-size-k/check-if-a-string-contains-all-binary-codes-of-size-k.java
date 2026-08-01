class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashMap<String, Integer>map= new HashMap<>();

        for(int i=0; i+k <=s.length(); i++){ ///we don't want codes to be out og s.length()
            String binaryCodes= s.substring(i, i+k);
            map.put(binaryCodes, map.getOrDefault(binaryCodes, 0)+1);
        }
        return map.size()==(1<<k); //1<<k will compute total no. of binarycodes of length k. << shifts left by 1 all the remaining values will be 0 
        //for e.g. 0001 -> 0010 -> 0100 -> 1000 thus, all the binary codes will be generated.
    }
}