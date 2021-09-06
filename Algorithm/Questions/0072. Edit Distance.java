class Solution {
    public int minDistance(String word1, String word2) {
        // let dp[i][j] be minimum step to convert word1[0...i - 1] into word2[0....j - 1]
        // dp[i][j] = Math.min(
        //  dp[i - 1][j] + 1 // delete
        //  dp[i][j - 1] + 1 // add
        //  dp[i - 1][j - 1]  + 1// edit
        //  dp[i - 1][j - 1] // matched and do nothing
        // )
        
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int m = w1.length;
        int n = w2.length;
        
        int[][] dp = new int[2][n + 1];
        
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = 0;
                    continue;
                }
                
                if (i == 0) {
                    dp[i % 2][j] = j;
                    continue;
                }
                if (j == 0) {
                    dp[i % 2][j] = i;
                    continue;
                }
                dp[i % 2][j] = Integer.MAX_VALUE;
                if (w1[i - 1] == w2[j - 1]) { // equal
                    dp[i % 2][j] = Math.min(dp[i % 2][j], dp[(i - 1) % 2][j - 1]);
                    continue;
                }
                
                dp[i % 2][j] =  Math.min(dp[i % 2][j], Math.min(dp[(i - 1) % 2][j] + 1, Math.min(dp[i % 2][j - 1] + 1, dp[(i - 1) % 2][j - 1]  + 1)));
            }
        }
        
        return dp[m % 2][n];
        
    }
}