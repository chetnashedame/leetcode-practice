class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n= barcodes.length;

    Map<Integer, Integer> map = new HashMap<>();
        for (int num:barcodes) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

    
      for (int key:map.keySet()) {
            pq.offer(new int[]{key, map.get(key)});
        }

    int[] res = new int[n];
    int i=0;

       while(!pq.isEmpty()){
        int []curr=pq.poll();
        int num=curr[0];
        int freq=curr[1];
    
    
    while(freq-- >0){
        if(i>=n) i=1;   //odd index
        res[i]=num;
        i+=2;
    }
    } 
    return res;
}
}