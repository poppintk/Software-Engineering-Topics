class LRUCache {
    public class ListNode {
        public Integer key;
        public Integer value;
        public ListNode next;
        public ListNode (Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }
    
    
    // use single linkedlist
    Map<Integer, ListNode> prevMap = new HashMap<>();
    ListNode dummy;
    ListNode tail;
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy = new ListNode(-1, -1);
        tail = dummy;
        capacity = capacity;
    }
    
    private void pushback(ListNode node) {
        prevMap.put(node.key, tail); // Note: set to tail
        tail.next = node;
        tail = node;
    }
    /*
    * prev -> node -> n2 .... -> tail
    *  => prev -> n2 ....-> node(tail)
    */
    private void kickToTail(ListNode prev) {
        ListNode node = prev.next;
        if (node == tail) return; // NOTE: if node is tail
        // remove from the linkedlist
        prev.next = node.next;
        // update prevMap
        prevMap.remove(node.key);
        prevMap.put(node.next.key, prev);// n2's pointer in map now point to node
        
        node.next = null;
        
        pushback(node);
        
    }
    
    public int get(int key) {
        if (!prevMap.containsKey(key)) return -1;
        ListNode prev = prevMap.get(key);
        ListNode currentNode = prev.next;
        kickToTail(prev);
        return currentNode.value;
    }
    
    public void put(int key, int value) {
        if (prevMap.containsKey(key)) {
            // update existing
            ListNode prev = prevMap.get(key);
            kickToTail(prev);
            tail.value = value;
            return;
        }
        
        // adding new
        ListNode node = new ListNode(key, value);
        pushback(node);
        if (prevMap.size() > capacity) {
            // pop out lease rencently used, pop front
            ListNode removeNode = dummy.next;
            // remove from the linkedlist
            dummy.next = removeNode.next;
            // update prevMap
            prevMap.remove(removeNode.key);
            prevMap.put(removeNode.next.key, dummy);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */