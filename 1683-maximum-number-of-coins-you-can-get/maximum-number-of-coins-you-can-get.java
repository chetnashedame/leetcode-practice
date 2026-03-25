class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);

        int n=piles.length;
        int ans=0;

        int i=n-2;
        int count=n/3;

        while(count-- >0){
            ans+=piles[i];
            i -=2;
        }
        return ans;
    }
}