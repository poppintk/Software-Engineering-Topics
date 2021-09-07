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
    // Note: This question can go only one path, unlike 104
    public int minDepth(TreeNode root) {
        return dfs(root);
    }
    
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        if(root.left == null) return dfs(root.right) + 1;
        if(root.right == null) return dfs(root.left) + 1;
        
        return Math.min(dfs(root.left), dfs(root.right)) + 1;
    }
}