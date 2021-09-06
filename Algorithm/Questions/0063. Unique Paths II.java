class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // let dp[i][j] be number of ways to i, j
        // dp[i][j] = dp[i - 1][j] + dp[i][j - 1] 
        
        int[][] dp = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = grid[i][j] != 1 ? 1 : 0;
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = grid[i][j] != 1 ? dp[i][j - 1] : 0;
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = grid[i][j] != 1 ? dp[i - 1][j] : 0;
                    continue;
                }
                
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        
        return dp[m - 1][n - 1];
    }
}