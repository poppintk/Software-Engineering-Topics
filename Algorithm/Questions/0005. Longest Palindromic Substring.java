class Solution {
    // TODO, loop way and recursion way
    public String longestPalindrome(String s) {
        // let dp[i][j] be whether is palindrome for the ith jth index in the string 's'
        // dp[i][j] = dp[i + 1][j - 1] | such that s[i] == s[j]
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        char[] ss = s.toCharArray();
        
        int startIndex = 0;
        
        // init
        // len 1
        int longest = 1;
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        // len 2
        for (int i = 0; i < s.length() - 1; i++) {
            dp[i][i + 1] = (ss[i] == ss[i + 1]);
            if (dp[i][i + 1]) {
                longest = 2;
                startIndex = i;
            }
        }
        
        // len3
        for (int len = 3; len <= s.length(); len++) {
            for(int i = 0; i < s.length() - len + 1; i++) { // issue
                // len + i - 1 = j;
                int j = len + i - 1;
                if (ss[i] == ss[j]) {
                    dp[i][j] = dp[i + 1][j - 1];
                }
                if (dp[i][j] && len > longest) {
                    longest = len;
                    startIndex = i;
                }
            }
        }
        
        return s.substring(startIndex, startIndex + longest);
    }
}