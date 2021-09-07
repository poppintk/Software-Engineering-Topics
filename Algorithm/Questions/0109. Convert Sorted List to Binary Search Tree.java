/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        return dfs(head, null);
    }
    private TreeNode dfs(ListNode head, ListNode tail) {
        if(head == tail){
            return null;
        }
        // step 1. cut the list to two halves
        ListNode slow = head, fast = head;

        while (fast != tail && fast.next != tail) { // tips 
          slow = slow.next;
          fast = fast.next.next;
        }
        // if linkedList size is odd, fast will be the last node and slow will be on index Math.floor(size/2)
        // if linkedList size is even, fast will be null pointer at the end and slow will be on index size/2
        
        TreeNode node = new TreeNode(slow.val); // slow is mid
        node.left = dfs(head,slow);
        node.right = dfs(slow.next,tail);
        return node;
    }
}