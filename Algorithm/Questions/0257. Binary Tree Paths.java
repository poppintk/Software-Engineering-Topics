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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        dfs(root, ans, "");
        return ans;
    }
    
    private void dfs(TreeNode root, List<String> ans, String path) {
        if (root == null) return;
        
        if (root.left == null && root.right == null) {
            ans.add(path + root.val);
            return;
        }
        
        dfs(root.left, ans, path + root.val +  "->");
        dfs(root.right, ans, path + root.val + "->");
    }
}