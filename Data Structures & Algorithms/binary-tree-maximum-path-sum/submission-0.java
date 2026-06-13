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
    int maxP = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);

        return maxP;
    }

    public int maxSum(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int l = maxSum(root.left);
        if(l < 0) {
            l = 0;
        }
        int r = maxSum(root.right);
        if(r < 0) {
            r = 0;
        }
        maxP = Math.max(maxP, l+r+root.val);

        return Math.max(l+root.val, r+root.val); 
    }
}
