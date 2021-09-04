class Solution {
    public boolean isMatch(String s, String p) {
        char[] S = s.toCharArray();
        char[] P = p.toCharArray();
        
        int m = S.length;
        int n = P.length;
        // Let dp[i][j] be true if the first i characters in s (s[0...i-1]) can match with the first j charaters in p (p[0...j-1]), Otherwise, false
        // dp[i][j] = dp[i - 1][j - 1]      if S[i - 1] == P[j - 1] 
        // dp[i][j] = dp[i - 1][j - 1]      if P[j - 1] == ?
        // dp[i][j] = dp[i][j - 1] match nothing     if P[j - 1] == *
        // dp[i][j] = dp[i - 1][j] match more        if P[j - 1] == *
    
            
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                
                if (i >= 1 && j >= 1 && (S[i - 1] == P[j - 1] || P[j - 1] == '?')) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - 1];
                }
                else if (j >= 1 && P[j - 1] == '*') {
                    if (i >= 1) {
                       dp[i][j] = dp[i - 1][j]; 
                    }
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
            }
        }
        
        
        return dp[m][n];
    }
}