class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        
        // dp[i][j] be minimum path sum at index i, j
        // dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j)
        
        
        int[][] dp = new int[m][n];
        
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = triangle.get(i).size() - 1; j >= 0; j--) { // j start from triangle.get(i).size() - 1
                if (i == m - 1) {
                    dp[i][j] = triangle.get(i).get(j);
                    continue;
                }
   
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
                
            }
        }
        
        return dp[0][0];
    }
}