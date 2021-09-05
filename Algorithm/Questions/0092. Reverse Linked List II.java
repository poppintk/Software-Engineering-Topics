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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null) return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        // find first node
        ListNode cur = dummy;
        ListNode beforeLeft = dummy;
        int i = 0;
        while (cur != null && i < left) {
            i++;
            beforeLeft = cur;
            cur = cur.next;
        }
        
        ListNode last = cur;
        
        // reverse
        ListNode prev = null;
        while (cur != null && i <= right) { // interval is [left, right], note i <= right cover reverse right
            i++;
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;         
        }
        
        
        last.next = cur;
        beforeLeft.next = prev;
        return dummy.next;
    }
}