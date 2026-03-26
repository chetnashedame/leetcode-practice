class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
         Arrays.sort(coins); // Step 1

        long maxReach = 0;  // can form [1 … maxReach]
        int i = 0;
        int added = 0;

        while (maxReach < target) {

            // use existing coin
            if (i < coins.length && coins[i] <= maxReach + 1) {
                maxReach += coins[i];
                i++;
            } 
            // add new coin
            else {
                long newCoin = maxReach + 1;
                maxReach += newCoin;
                added++;
            }
        }return added;
    }
}

//coins = [1,4,10]
//target = 19

// maxReach = 0
// coin = 1 ≤ 1 → use it
// maxReach = 1

// coin = 4 > 2 → missing 2
// add coin = 2
// maxReach = 3
// added = 1

// coin = 4 ≤ 4 → use it
// maxReach = 7

// coin = 10 > 8 → missing 8
//  add coin = 8
// maxReach = 15
// added = 2

// coin = 10 ≤ 16 → use it
// maxReach = 25 ≥ target

// ans=2.  Time: O(n log n)
// Space: O(1)