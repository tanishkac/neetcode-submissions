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
    int count = 0;
    int max = Integer.MIN_VALUE;
    public int goodNodes(TreeNode root) {
        goodnodes(root, max);
        return count;
    }
    public void goodnodes(TreeNode root, int max) {
        TreeNode node = root;
        if(node == null) {
            return;
        }
        if(node.val >= max) {
            count++;
            max = node.val;
        }
        goodnodes(node.left, max);
        goodnodes(node.right, max);
    }
}
