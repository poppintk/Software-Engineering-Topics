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
    public List<Integer> preorderTraversal(TreeNode root) {
        return iterative(root);
    }
    
    private List<Integer> recursive(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorder(root, ans);
        
        return ans;
    }
    
    private void preorder(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        
        ans.add(root.val);
        preorder(root.left, ans);
        preorder(root.right, ans);
    }
    
    private List<Integer> iterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if (root == null) return new ArrayList<>();
        
        Stack<TreeNode> stack = new Stack<>();
        pushAllLeft(root, stack, result);
        TreeNode cur = null;
        while(!stack.isEmpty()){
            cur = stack.pop();
            pushAllLeft(cur.right, stack, result);
        }
        return result;
    }
    
    public void pushAllLeft(TreeNode root, Stack<TreeNode> stack, List<Integer> result){
        TreeNode cur = root;
        while(cur != null){
            result.add(cur.val);
            stack.add(cur);
            cur = cur.left;
        }
    }

}