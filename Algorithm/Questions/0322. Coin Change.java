class Solution {
    public int coinChange(int[] coins, int amount) {
        // let dp[i] be the fewest number of coins that need to make up that amount i
        // dp[i] = Math.min(dp[i], dp[i - coin] + 1) for coin in coins
        
        int[] dp = new int[amount + 1];
        
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) { // NOTE: boundary case
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}