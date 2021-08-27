class Solution {
    // priority queue O(nKlogK)  where nk is number of nodes  and space is O(k)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        Queue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) continue;
            queue.add(lists[i]);
        }
        
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode prev = dummy;
        while (!queue.isEmpty()) {
            ListNode cur = queue.poll();

            prev.next = cur;
            
            if (cur.next != null) {
                queue.add(cur.next);
            }
            
            prev = cur;
        }
        
        return dummy.next;
    }
}
// Divide and conquer O(nlogK)  where n is average number of in the ListNode  and space is O(log k) k is size of the lists
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        return divideConquer(lists, 0, lists.length - 1);
    }
    
    private ListNode divideConquer(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        
        int mid = left + (right - left) / 2;
        
        ListNode leftList = divideConquer(lists, left, mid);
        ListNode rightList = divideConquer(lists, mid + 1, right);
        
        return merge(leftList, rightList);
    }
    
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        ListNode l = left;
        ListNode r = right;
        while (l != null && r != null) {
            if (l.val > r.val) {
                cur.next = new ListNode(r.val);
                r = r.next;
            } else {
                cur.next = new ListNode(l.val);
                l = l.next;
            }
            cur = cur.next;
        }
        
        if (l != null) {
            cur.next = l;
        }
        
        if (r != null) {
            cur.next = r;
        }
        
        return dummy.next;
    }
}