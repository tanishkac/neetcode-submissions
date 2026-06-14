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
    List<Integer> map = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return map.get(k-1);
    }

    public void traverse(TreeNode root, int k) {
        TreeNode node = root;

        if(map.size() == k) {
            return;
        }

        if(node == null) {
           return;
        }
        
        traverse(node.left, k);
        map.add(node.val);
        traverse(node.right, k);  
    }
}