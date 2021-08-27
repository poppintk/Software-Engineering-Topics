class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(0,0, n, ans, "");
        
        return ans;
    }
    
    private void dfs(int left, int right, int n, List<String> ans, String path) {
        if (right == n) {
            ans.add(path);
            return;
        }
        
        if (left < n) {
            dfs(left + 1, right, n, ans, path + "(");
        }
        if (right < left) {
            dfs(left, right + 1, n, ans, path + ")");
        }
        
    }
}