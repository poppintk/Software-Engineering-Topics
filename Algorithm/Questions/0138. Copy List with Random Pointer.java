/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        
        
        // copy node
        Map<Node, Node> nodes = copyNode(head);
        // copy link
        copyLink(head, nodes);
        
        
        return nodes.get(head);
    }
    
    private void copyLink(Node head, Map<Node, Node> nodes) {
        Node cur = head;
        while (cur != null) {
            Node copy = nodes.get(cur);
            copy.next = nodes.get(cur.next);
            copy.random = nodes.get(cur.random);
            cur = cur.next;
        }
    }
    
    private  Map<Node, Node> copyNode(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        
        return map;
    }
}