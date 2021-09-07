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
    Map<Integer, Integer> map = new HashMap<>();
    // preorder : root at first one 
    // postorder: root at the last one
    // inorder: root at the somewhere between first and last one
    // idea is find the root node, then construct left and right substree
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        
        // use map to increase performance
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
    
        return constructTree(postorder, inorder,  0, n - 1, 0, n - 1);
    }
    
    
    private TreeNode constructTree(int[] postorder, int[] inorder, int postStart, int postEnd, int inStart, int inEnd) {
        if (postStart > postEnd) return null;
        if (postStart == postEnd) return new TreeNode(postorder[postStart]);
        
        // get root index in inorder
        int rootVal = postorder[postEnd];
        int idx = map.get(rootVal);
        
        TreeNode root = new TreeNode(rootVal);    
        root.left = constructTree(postorder, inorder, postStart , postStart + idx - inStart - 1, inStart, idx - 1);
        root.right = constructTree(postorder, inorder, postStart + idx - inStart, postEnd - 1, idx + 1, inEnd);
    
        return root;
    }
}