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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(ans, path, root, targetSum);
        return ans;
    }
    
    private void dfs(List<List<Integer>> ans, List<Integer> path, TreeNode root, int targetSum) {
        if (root == null) return;
        if (root.left == null && root.right == null && targetSum - root.val == 0) {
            path.add(root.val);
            ans.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        
        path.add(root.val);
        dfs(ans, path, root.left, targetSum - root.val);
        dfs(ans, path, root.right, targetSum - root.val);
        path.remove(path.size() - 1);
    }
}