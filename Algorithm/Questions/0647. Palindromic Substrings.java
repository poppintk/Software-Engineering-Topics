class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        // let dp[i][j] be the substring of s[i,j] is true if it's palindromic substring
        boolean [][] dp = new boolean[n][n];
        
        int count = 0;
        // len 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            count += 1;
        }
        // len 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                count += 1;
            }
        }
        
        
        int j = 0;
        for(int len = 3; len < n + 1; len++){
            for(int i = 0; i < n - len + 1; i++){
                j = i + len - 1;
                if(dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = true;
                    count += 1;
                }
            }
        }
        return count;
        
    }
}