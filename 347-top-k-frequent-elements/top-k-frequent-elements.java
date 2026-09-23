class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap= new HashMap<>(); //create a fre hashmap to store the freq of every num

        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }

        List<Integer>[] buckets= new List[nums.length+1];  //create array of list to store nums having same freq 

        for(Map.Entry<Integer, Integer> entry: freqMap.entrySet()){
            int num= entry.getKey();
            int freq= entry.getValue();
            if(buckets[freq]==null){
                buckets[freq]= new ArrayList<>();
            }
            buckets[freq].add(num);
        }

        int []result= new int[k];  //take array to store res
        int index=0;   //index = freq so we get at index 1 we have freq1 means nums that are 1  so if we loop backwords we get highest k freq 
        for(int freq= buckets.length-1; freq>=0 && index<k; freq--){
            if(buckets[freq]!=null){
                for(int num:buckets[freq]){
                    result[index++]=num;
                    if(index==k) break;
                }
            }
        }
    return result;

    }
}