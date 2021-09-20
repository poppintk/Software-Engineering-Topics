class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = buildGraph(tickets);
        LinkedList<String> ans = new LinkedList<>();
        dfs(graph, ans, "JFK");
        
        return ans;
    }
    
    private void dfs(Map<String, PriorityQueue<String>> graph, LinkedList<String> ans, String from) {
        
        PriorityQueue<String> destination = graph.get(from);
        
        while (destination != null && !destination.isEmpty()) {
            String next = destination.poll();
            dfs(graph, ans, next);
        }
        ans.addFirst(from);
    }
    
    private Map<String, PriorityQueue<String>> buildGraph(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if(!graph.containsKey(from)) graph.put(from, new PriorityQueue<>());
            graph.get(from).add(to);
        }
        return graph;
    }
}