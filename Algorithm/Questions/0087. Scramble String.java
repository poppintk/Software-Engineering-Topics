class Solution {
    public boolean isScramble(String s1, String s2) {
        // let dp[i][j][k] be the whehter or not the s1[i....i + k - 1] is scramble with s2[j...j + k - 1]
        // dp[i][j][k] = for 1 <= w <= k - 1 (dp[i][j][w] AND dp[i + w][j + w][k - w])
        // OR for 1 <= w <= k - 1 (dp[i][j + k - w][w] AND dp[i + w][j][k - w])
        
        int n = s1.length();
        int m = s2.length();
        
        if (n != m) return false;
        
        boolean[][][] dp = new boolean[n][n][n + 1];
        // len = 1
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                dp[i][j][1] = (s1.charAt(i) == s2.charAt(j));
            }
        }
        
        for (int len = 2; len <= n; ++len) {
            for (int i = 0; i < n - len + 1; ++i) {
                for (int j = 0; j < n - len + 1; ++j) {
                    for (int w = 1; w < len; ++w) {
                        // no swap
                        if (dp[i][j][w] && dp[i + w][j + w][len - w]) {
                            dp[i][j][len] = true;
                            break;
                        }

                        // swap
                        if (dp[i][j + len - w][w] && dp[i + w][j][len - w]) {
                            dp[i][j][len] = true;
                            break;
                        }
                    }      
                }
            }
        }
        
        return dp[0][0][n];
    }
}