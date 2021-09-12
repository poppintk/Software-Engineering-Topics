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
    public List<Integer> postorderTraversal(TreeNode root) {
        return iterative(root);
    }
    
    private List<Integer> iterative(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return ans;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.left != null) stack.push(cur.left);
            if (cur.right != null) stack.push(cur.right);
            ans.addFirst(cur.val);
        }
        return ans;
    }
    
    
    
    private List<Integer> recursive(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }
    
    private void dfs(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        
        dfs(root.left, ans);
        dfs(root.right, ans);
        ans.add(root.val);
    }
}