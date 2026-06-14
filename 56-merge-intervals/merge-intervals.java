class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]>merged=new ArrayList<>();
        int [] first=intervals[0];

        for(int i=1; i<intervals.length; i++){
            int[] interval=intervals[i];
            if(interval[0]<= first[1]){
                first[1]=Math.max(first[1], interval[1]);
            }else{
                merged.add(first);
                first=interval;
            }
        }
        merged.add(first);

        return merged.toArray(new int [merged.size()][]);
    }
}