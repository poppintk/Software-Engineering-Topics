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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        head = dummy;
        while (head.next != null) {
            head = reverseKth(head, k);
        }
        
        return dummy.next;
    }
    
    // reverse head->n1->..->nk->next..
    // to head->nk->..->n1->next..
    // return n1, by definetion return the last node of current k
    private ListNode reverseKth(ListNode head, int k) {
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            if (cur.next == null) return cur; // no enough then no reverse
            cur = cur.next;
        }
        
        ListNode n1 = head.next;
        cur = n1;
        ListNode prev = null;
        int i = 0;
        while (cur != null) {
            if (i == k) break;
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            i++;
        }
        n1.next = cur;
        head.next = prev;
        return n1;
    }
}