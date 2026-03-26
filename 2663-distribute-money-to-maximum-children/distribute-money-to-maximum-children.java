class Solution {
    public int distMoney(int money, int children) {
// 1. Give 1 to each child
// 2. Try to convert children into 8 (need +7)
// 3. Handle edge cases:
//    - leftover = 3 → creates 4
//    - extra after all 8 → invalid

        // Step 1: each child must get at least 1
        if (money < children) return -1;

        money -= children; // remaining money after giving 1 each

        // If we cannot make any 8
        if (money < 7) return 0;

        int count = 0; // number of children getting 8
        int n = children;

        // Step 2: try to give 7 extra (to make 8)
        while (money >= 7 && n > 0) {
            money -= 7;
            count++;
            n--;
        }

        //  Case 1: leftover = 3 and one child left → creates 4 
        if (money == 3 && count == children - 1) {
            return count - 1;
        }

        //  Case 2: all children got 8 but still money left 
        if (count == children && money > 0) {
            return count - 1;
        }

        return count;
    }
}