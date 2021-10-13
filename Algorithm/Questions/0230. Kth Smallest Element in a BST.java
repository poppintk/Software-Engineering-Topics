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
    private int index, kth;
    public int kthSmallest(TreeNode root, int k) {
        index = 0;
        inorder(root, k);
        return kth;
    }
    
    private void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        
        inorder(root.left, k);
        index++;
        if (index == k) {
            kth = root.val;
        }
        
        if (index < k) { // optimize
            inorder(root.right, k);
        }
    }
}