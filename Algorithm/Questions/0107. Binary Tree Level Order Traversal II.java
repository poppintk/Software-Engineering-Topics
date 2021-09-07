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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        return bfs(root,result);
    }
    
    public List<List<Integer>> bfs(TreeNode root, List<List<Integer>> result){
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        List<Integer> temp = null;
        while(!queue.isEmpty()){
            int size = queue.size();
            temp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                temp.add(cur.val);
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
            result.add(0,temp);
        }
        
        
        return result;
    }
}