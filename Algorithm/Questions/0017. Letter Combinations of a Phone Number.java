class Solution {
    
    private Map<Character, List<Character>> map = Map.of(
        '2', List.of('a', 'b', 'c'),
        '3', List.of('d', 'e', 'f'),
        '4', List.of('g', 'h', 'i'),
        '5', List.of('j', 'k', 'l'),
        '6', List.of('m', 'n', 'o'),
        '7', List.of('p', 'q', 'r', 's'),
        '8', List.of('t', 'u', 'v'),
        '9', List.of('w', 'x', 'y', 'z')
    );
    
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) return ans;
        
        dfs(ans, "", 0, digits);
        
        return ans;
    }
    
    private void dfs(List<String> ans, String path, int depth, String digits) {
        if (depth == digits.length()) {
            ans.add(String.valueOf(path));
            return;
        }
        
        char digit = digits.charAt(depth);
        List<Character> arr = map.get(digit);
        for (int i = 0; i < arr.size(); i++) {
            char c = arr.get(i);
            dfs(ans, path + c, depth + 1, digits);
        }
    }
}