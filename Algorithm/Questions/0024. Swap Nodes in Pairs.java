class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        
        while (cur.next != null) {
            cur = reverseKth(cur, 2);
        }
            
            
        return dummy.next;
    }
    
    
    // reverse head->n1->..->nk->next..
    // to head->nk->..->n1->next..
    // return n1
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
        while (cur != null && i < k) {
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
