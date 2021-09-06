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
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy.next;
        ListNode prev = cur;
        
        while (cur != null) {
            while(cur != null && cur.next != null && cur.val == cur.next.val) { // find last node is duplicated
                cur = cur.next;
            }
            
            prev.next = cur.next;
            prev = prev.next;
            cur = cur.next;
        }
        
        
        return dummy.next;
    }
}