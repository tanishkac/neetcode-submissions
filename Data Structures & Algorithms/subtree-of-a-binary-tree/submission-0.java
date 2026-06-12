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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode node = root;
        if(root != null && subRoot != null) {
            q.add(root);
        } else {
            return false;
        }
        while(!q.isEmpty()) {
            int size = q.size();
            

            for(int i=0; i<size; i++) {
                node = q.remove();
                boolean st = sameTree(node, subRoot);
                if(st == true) {
                    return true;
                } 
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                } 
            }
        }

        return false;
    }

    public boolean sameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        if(p.val != q.val) {
            return false;
        }
        boolean lc = sameTree(p.left , q.left);
        if(lc == false) {
            return false;
        }
        boolean rc = sameTree(p.right , q.right);
        
        return rc;
    }
}
