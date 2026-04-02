/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int maxFreq = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);

        List<Integer> res = new ArrayList<>();

        for (int key : map.keySet()) {
            if (map.get(key) == maxFreq) {
                res.add(key);
            }
        }

        return res.stream().mapToInt(i -> i).toArray(); // mapToInt() ->Integer to int
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        int sum = node.val + left + right;

        map.put(sum, map.getOrDefault(sum, 0) + 1);

        maxFreq = Math.max(maxFreq, map.get(sum));

        return sum;
    }
}