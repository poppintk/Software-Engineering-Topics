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
        ListNode fast = dummy;
        ListNode slow = fast;
        
        
        while (fast != null) {
            while (fast.next != null && fast.val == fast.next.val) { // in array representation, this is nums[i] == nums[i + 1]
     		    fast = fast.next;    //while loop to find the last node of the dups.
            }
            if (slow.next != fast) { //duplicates detected. if has duplicate fast not should not equal to slow
                slow.next = fast.next; //remove the dups.
                fast = slow.next;     //reposition the fast pointer.
            } else { //no dup, move down both pointer.
                slow = slow.next;
                fast = fast.next;
            }
        }
        
        
        return dummy.next;
    }
}
