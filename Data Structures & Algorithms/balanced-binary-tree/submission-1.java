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
    boolean bal = true;
    public boolean isBalanced(TreeNode root) {
        depth(root);
        return bal;
    }

    public int depth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int l = depth(root.left);
        int r = depth(root.right);
        int diff = Math.abs(l-r);
        if(diff > 1){
            bal = false;
        } 
        return Math.max(l+1, r+1);
    }
}
