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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        TreeNode n1 = p;
        TreeNode n2 = q;

        if(n1 == null && n2 == null) {
            return true;
        } 

        if(n1 == null || n2 == null) {
            return false;
        }

        if(n1.val != n2.val) {
            return false;
        }

        q1.add(n1);
        q2.add(n2);

        while(!q1.isEmpty() && !q2.isEmpty()) {
            int s1 = q1.size();
            int s2 = q2.size();
            n1 = q1.remove();
            n2 = q2.remove();
            
            for(int i=0; i<s1; i++) {
                if(n1 == null && n2 == null) {
                    continue;
                } 

                if(n1 == null || n2 == null) {
                    return false;
                }

                if(n1.val != n2.val) {
                    return false;
                }

                q1.add(n1.left);
                q2.add(n2.left);
                q1.add(n1.right);
                q2.add(n2.right);
            }
            
        }

        return true;
    }
}
