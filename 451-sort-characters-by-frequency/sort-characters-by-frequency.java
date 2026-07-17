class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> countMap= new HashMap<>();
        for(char c:s.toCharArray()){
            countMap.put(c, countMap.getOrDefault(c,0)+1);
        }

        List<Character> [] buckets= new List[s.length()+1];
        for(Map.Entry<Character, Integer> entries: countMap.entrySet()){
            int f= entries.getValue();
            if(buckets[f]==null){
                buckets[f]=new ArrayList<>();
            }    
            buckets[f].add(entries.getKey());
            

        }

        StringBuilder sb= new StringBuilder();
        for(int i=buckets.length-1; i>0; i--){
            if(buckets[i] != null){
                for(char c:buckets[i]){
                    for(int j=0; j<i; j++){
                    sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}