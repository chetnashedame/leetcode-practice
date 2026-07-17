class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> countMap= new HashMap<>();
        for(char c:s.toCharArray()){
            countMap.put(c, countMap.getOrDefault(c,0)+1);
        }

       PriorityQueue<Map.Entry<Character, Integer>> maxHeap= new PriorityQueue<>((a,b) -> b.getValue()-a.getValue());

       maxHeap.addAll(countMap.entrySet());

       StringBuilder sb= new StringBuilder();
       while(!maxHeap.isEmpty()){
        Map.Entry<Character,Integer> entry = maxHeap.poll();
        char c = entry.getKey();
        int count = entry.getValue();
        for(int i=0; i<count; i++){
            sb.append(c);
        }

       }
       return sb.toString();
    }
}