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
        
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = fast;
        
        while (fast != null) {
            while(fast.next != null && fast.val == fast.next.val) { // find last node is duplicated
                fast = fast.next;
            }
            
            slow.next = fast.next;
            slow = slow.next;
            fast = fast.next;
        }
        
        
        return dummy.next;
    }
}
