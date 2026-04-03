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
    int preIndex=0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++){
             map.put(inorder[i],i);
        }

        return getRoot(preorder,0, inorder.length-1);


    }
        private TreeNode getRoot(int [] preorder, int left, int right){
            if(left>right)return null;
        
        int rootVal=preorder[preIndex++];
        TreeNode root= new TreeNode (rootVal);

        int index=map.get(rootVal);

        root.left=getRoot(preorder, left, index-1);
        root.right=getRoot(preorder,index+1 ,right);
        return root;
        }
    
}