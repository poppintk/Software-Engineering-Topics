class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        backtracking(ans, path, n, k, 1);
        
        return ans;
    }
    
    private void backtracking(List<List<Integer>> ans, List<Integer> path, int n, int k, int from) {
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = from; i <= n; i++) {
            
            path.add(i);
            backtracking(ans, path, n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }
}