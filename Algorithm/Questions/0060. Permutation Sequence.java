class Solution {
    /**
     * Bruce force ,TODO better way 
     */
    public String getPermutation(int n, int k) {
        List<String> ans = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        backtracking(ans, "", visited, n, k);
        return ans.get(ans.size() - 1);
    }
    
    private void backtracking(List<String> ans, String path, boolean[] visited, int n, int k) {
        if (path.length() == n) {
            ans.add(path);
            return;
        }
        if (ans.size() >= k) return;
        
        for (int i = 1; i <= n ; i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            backtracking(ans, path + i, visited, n, k);
            visited[i] = false;
        }
    }
}