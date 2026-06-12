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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode node = root;
        List<Integer> list = new ArrayList<>();
        if(node != null) {
            q.add(node);
        }

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                node = q.peek();
                if(i == 0) {
                    list.add(node.val);
                }
                q.remove();

                if(node.right != null) {
                    q.add(node.right);
                }
                if(node.left != null) {
                    q.add(node.left);
                }
            }
        }
        return list;
    }
}