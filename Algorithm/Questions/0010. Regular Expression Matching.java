class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || s.length() == 0) return false;
        if (p == null || p.length() == 0) return false;
        
        char[] S = s.toCharArray();
        char[] P = p.toCharArray();
        
        // Let dp[i][j] be true if the first i characters in s (s[0...i-1]) can match with the first j charaters in p (p[0...j-1]), Otherwise, false
        // case one: if s[i - 1] == p[j - 1] => dp[i][j] = dp[i - 1][j - 1]
        // case two: if p[j - 1] == '.' => dp[i][j] = dp[i - 1][j - 1]
        // case three: p[j - 1] == '*' 
        //          => dp[i][j] = dp[i][j - 2] (match 0 of 'c' case like c*)
        //          if P[j - 2] == S[i - 1] || P[j - 2] == '.' => dp[i][j] = dp[i - 1][j] (match more of 'c') 
        
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = false;
                    continue;
                }
                
                if (P[j - 1] != '*') {
                    if (i >= 1 && (P[j - 1] == '.' ||  S[i - 1] == P[j - 1])) {
                        dp[i][j] = dp[i - 1][j - 1];  
                    }
                 }
                 else {
                    if (j >= 2) {
                        dp[i][j] = dp[i][j - 2];
                    }
                    if (j >= 2 && i >= 1 && (P[j - 2] == S[i - 1] || P[j - 2] == '.')) {
                        dp[i][j] =  dp[i][j] || dp[i - 1][j];
                    }
                   
                    
                }
            }
        }
        
        return dp[n][m];
    }
}