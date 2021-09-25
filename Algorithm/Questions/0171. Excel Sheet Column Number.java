class Solution {
    public int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            int n = chars[i] - 'A' + 1;
            ans = (n + ans * 26);
        }
        
        return ans;
    }
}