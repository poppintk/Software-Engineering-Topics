class Solution {
    public int minPathSum(int[][] grid) {
        // dp[i][j] be the min sum at i, j
        // dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]);
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = grid[0][0];
                    continue;
                }        
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                    continue;
                }
                
                dp[i][j] = Integer.MAX_VALUE;
                dp[i][j] = Math.min(dp[i][j - 1]+ grid[i][j], dp[i - 1][j]+ grid[i][j]) ;
            }
        }
        
        
        return dp[m - 1][n - 1];
    }
}