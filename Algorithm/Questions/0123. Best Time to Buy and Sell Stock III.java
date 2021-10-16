class Solution {
    // TODO: code can be simplified a bit
    public int maxProfit(int[] prices) {
        // write your code here
        // let dp[i][j] be the first i days that in j state
        // dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i - 1] - prices[i - 2]); if j in 1,3,5 no stock on hand
        // dp[i][j] = Math.max(dp[i - 1][j] + prices[i - 1] - prices[i - 2], dp[i - 1][j - 1]); if j in 2,4 has stock on hand


        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int[][] dp = new int[n + 1][6];

        for (int i = 1; i <= 5; i++) {
            dp[0][i] = Integer.MIN_VALUE;
        }
        dp[0][1] = 0;

        for (int i = 1; i <= n; i++) {
            // 1,3, 5
            for (int j = 1; j <= 5; j += 2) {
                dp[i][j] = dp[i - 1][j];
                // note j must be greater than 1. why? because 1代表第一階段無股票
                if (j >= 2 && i - 2 >= 0 && dp[i - 1][j - 1] != Integer.MIN_VALUE) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + prices[i - 1] - prices[i - 2]);
                }
            }

            // 2, 4
            for (int j = 2; j <= 5; j += 2) {
                dp[i][j] = dp[i - 1][j - 1];
                if (j >= 2 && i - 2 >= 0 && dp[i - 1][j] != Integer.MIN_VALUE) {
                    dp[i][j] = Math.max(dp[i - 1][j] + prices[i - 1] - prices[i - 2], dp[i][j]);
                }
            }
        }
        int ans = -1;
        for (int i = 1; i <= 5; i += 2) {
            ans = Math.max(ans, dp[n][i]);
        }

        return ans;
    }
}