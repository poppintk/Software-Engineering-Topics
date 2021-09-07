class Solution {
    // O(n^2)
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int getDepth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }
}

