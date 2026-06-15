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
    int k=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = buildtree(preorder, inorder, 0, inorder.length-1);
        return root;
    }

    public TreeNode buildtree(int[] preorder, int[] inorder, int l, int r) {
        if(l>r) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[k++]);

        if(l == r) {
            return root;
        }

        int i = 0;
        while(root.val != inorder[i]) {
            i++;
        }

        root.left = buildtree(preorder, inorder, l, i-1);
        root.right = buildtree(preorder, inorder, i+1, r);

        return root;
        
    }
}