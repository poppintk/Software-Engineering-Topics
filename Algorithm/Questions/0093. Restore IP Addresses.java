class Solution {
    /**
    *
    Constraints:

    0 <= s.length <= 3000
    s consists of digits only.
    
    */
    
    // O(3^4)
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() == 0) return ans;
        
        List<String> path = new ArrayList<>();
        dfs(ans, path, 0, s, 0);
        
        return ans;
    }
    
    private void dfs(List<String> ans, List<String> path, int depth, String s, int index) {
        if (depth == 4 && index == s.length()) {
            ans.add(String.join(".", path));
            return;
        }
        if (depth >= 4) return;
        
        for (int len = 1; len <= 3; len++) {
            if (index + len > s.length()) continue;
            String cur = s.substring(index, index + len);
            int val = Integer.valueOf(cur);
            if (cur.length() > 1 && cur.charAt(0) == '0') continue;
            if (val > 255) continue;
            path.add(cur);
            dfs(ans, path, depth + 1, s, index + len);
            path.remove(path.size() - 1);
        }
    }
}