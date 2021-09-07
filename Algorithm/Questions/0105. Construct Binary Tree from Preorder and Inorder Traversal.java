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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        
        // use map to increase performance
        
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        
        return constructTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }
    
    private TreeNode constructTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) return null;
        
        if (preStart == preEnd) return new TreeNode(preorder[preStart]);
        
        // get root index in inorder
        int rootVal = preorder[preStart];
        int idx = map.get(rootVal);
        
        TreeNode root = new TreeNode(rootVal);    
        root.left = constructTree(preorder, inorder, preStart + 1, preStart + idx - inStart, inStart, idx - 1);
        root.right = constructTree(preorder, inorder, preStart + idx - inStart + 1, preEnd, idx + 1, inEnd);
    
        return root;
    }
    

}