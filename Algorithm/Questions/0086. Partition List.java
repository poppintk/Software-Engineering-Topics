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
    /**
    *the basic idea is to maintain two queues, the first one stores all nodes with val less than x , and the second queue stores all the rest nodes. Then concat these two queues. Remember to set the tail of second queue a null next, or u will get TLE.
    */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        
        ListNode lessDummy = new ListNode(-1);
        ListNode greatDummy = new ListNode(-1);
        ListNode cur = head;
        ListNode curLess = lessDummy;
        ListNode curGreat = greatDummy;
        
        while (cur != null) {
            if (cur.val < x) {
                curLess.next = cur;
                curLess = curLess.next;
            } else {
                curGreat.next = cur;
                curGreat = curGreat.next;
            }
            
            cur = cur.next;
        }
        
        curLess.next = greatDummy.next;
        curGreat.next = null;
        
        return lessDummy.next;
    }
}