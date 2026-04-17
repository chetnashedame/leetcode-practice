class Solution {
    public int maxProfit(int[] prices) {
        int holding= Integer.MIN_VALUE;   ////dp state for holding dp[i][1]
        int notHolding =0;                  ///dp[i][0]

        for(int price:prices){
            holding= Math.max(holding, -price);     // buying day..only one transaction allowed
            notHolding=Math.max(notHolding, holding+price);    //selling for max profit 

        }
        return notHolding;
    }
}