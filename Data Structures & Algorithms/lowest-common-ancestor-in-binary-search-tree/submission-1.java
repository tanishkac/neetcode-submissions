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
    TreeNode node=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        node = root;

        if(p.val > node.val && q.val > node.val ) {
            lowestCommonAncestor(node.right, p, q);
        }
        else if(p.val < node.val && q.val < node.val) {
            lowestCommonAncestor(node.left, p, q);
        }
        else {
            return node;
        } 
        return node;
    }
}
