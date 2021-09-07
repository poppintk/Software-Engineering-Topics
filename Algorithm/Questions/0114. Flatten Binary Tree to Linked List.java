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
    public void flatten(TreeNode root) {
        if (root == null) return;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
            
            if (!stack.isEmpty()) {
                node.right = stack.peek(); // connecting part
            }
            node.left = null;
        }
        
    }
}