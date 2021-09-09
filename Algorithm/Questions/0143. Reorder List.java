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
    public void reorderList(ListNode head) {
        if (head.next == null) return;
        
        ListNode mid = findMid(head);

        ListNode node =  divideHalf(head, mid);

        merge(head, node);
    }
    
    private void merge(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            ListNode n1 = l1.next, n2 = l2.next;
            l1.next = l2;
            if (n1 == null) break;

            l2.next = n1;
            l1 = n1;
            l2 = n2;
            
        }
    }
    
    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        prev.next = null; // Note, divide
        return slow; // mid even will be on the index of size / 2, odd will on he index size / 2
    }
    
    private ListNode divideHalf(ListNode head, ListNode mid) {
        ListNode cur = mid;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        return prev;
    }
}