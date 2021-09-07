class Solution {
    public int numDistinct(String s, String t) {
        // let dp[i][j] be the number of ways that distinct subsequence of  s[0...i - 1]  and t[0...j - 1]
        // dp[i][j] = dp[i - 1][j - 1] if S[i - 1] == T[j - 1] (match one) 
        //          + dp[i - 1][j]  (match more)
    
        int m = s.length();
        int n = t.length();
        
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = 1;
                    continue;
                }
                
                if (i == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                
     
                if (S[i - 1] == T[j - 1]) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
                dp[i][j] += dp[i - 1][j];
                
            }
        }
        
        return dp[m][n];
    }
}