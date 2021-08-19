class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        
        Map<Character, Integer> visited = new HashMap<>();
        
        int right = 0;
        int left = 0;
        int ans = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            visited.put(c, visited.getOrDefault(c, 0) + 1);
            right++;
            
            while (visited.get(c) == 2) {
                char lc = s.charAt(left);
                visited.put(lc, visited.get(lc) - 1);
                if (visited.get(lc) == 0) {
                    visited.remove(lc);
                }
                left++;
            }
            // satisfy the condition
            ans = Math.max(ans, right - left);
        }
        
        return ans;
    }
}