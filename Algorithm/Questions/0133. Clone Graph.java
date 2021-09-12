/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        
        // get nodes
        List<Node> nodes = getNodes(node);
        
        // copy nodes
        Map<Node, Node> map = copyNode(nodes);
        
        // copy link
        copyEdge(nodes, map);
        
        return map.get(node);
    }
    
    private void copyEdge(List<Node> nodes, Map<Node,Node> map) {
        for (Node node : nodes) {
            Node copyNode = map.get(node);
            for (Node neibor : node.neighbors) {
                copyNode.neighbors.add(map.get(neibor));
            }
        }
    }
    
    private Map<Node, Node> copyNode(List<Node> nodes) {
        Map<Node, Node> map = new HashMap<>();
        
        for (Node next : nodes) {
            map.put(next, new Node(next.val));
        }
        
        return map;
    }
    
    private List<Node> getNodes(Node node) {
        Queue<Node> queue = new LinkedList<>();
        List<Node> nodes = new ArrayList<>();
        Set<Node> visited = new HashSet<>();
        
        queue.add(node);
        visited.add(node);
        
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            nodes.add(cur);
            for (Node neibor : cur.neighbors) {
                if (visited.contains(neibor)) continue;
                visited.add(neibor);
                queue.add(neibor);
            }
        }
        return nodes;
    }
}