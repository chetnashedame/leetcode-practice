class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        Set<String> set= new HashSet<>();

        for(int [] q : queens){
            set.add(q[0]+","+q[1]);
        }

        List<List<Integer>> res= new ArrayList<>();

        int[][] dirs= {
        {-1,0}, {1,0}, {0,-1}, {0,1}, {-1,-1}, {-1,1}, {1,-1}, {1,1} 
        };

        for(int[] d :dirs){
            int x= king[0];
            int y=king[1];

            while(x>=0 && x<8 && y>=0 && y<8){
                x+=d[0];
                y+=d[1];
             if(set.contains(x+","+y)){
                res.add(Arrays.asList(x,y));
                break;

             }

            }
        }
        return res;

    }
}