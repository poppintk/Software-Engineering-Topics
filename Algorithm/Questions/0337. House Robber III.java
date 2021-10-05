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
    public int rob(TreeNode root) {
        if(root == null) return 0; 
    
        int[] sums = robSubSum(root);
        return Math.max(sums[0], sums[1]); 
    }

    public int[] robSubSum(TreeNode root) {
        if(root == null) return new int[]{0,0}; 
    
        int[] leftSum = robSubSum(root.left); 
        int[] rightSum = robSubSum(root.right); 

        int[] sums = new int[2]; 
        // case of skip this node 
        sums[0] = Math.max(leftSum[0],leftSum[1]) + Math.max(rightSum[0],rightSum[1]);  
        // case of count this node 
        sums[1] = Math.max(sums[0], root.val + leftSum[0] + rightSum[0]); 

        return sums;
    }
}