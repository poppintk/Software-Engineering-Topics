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
    // top down
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode root, int currentSum) { // root as subtree and it's value
        if (root == null) return 0;
        currentSum = currentSum * 10 + root.val;
        if (root.left == null && root.right == null) return currentSum;
        int leftSum = dfs(root.left, currentSum);
        int rightSum = dfs(root.right, currentSum);
        return leftSum + rightSum;
    }
}