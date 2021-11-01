/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val) return root;
        
        TreeNode lnode = searchBST(root.left,val);
        TreeNode rnode = searchBST(root.right,val);
        
        if(lnode != null) return lnode;
        if(rnode != null) return rnode;
        return null;
    }
}