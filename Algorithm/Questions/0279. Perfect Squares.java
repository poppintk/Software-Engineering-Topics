class Solution {
    public int numSquares(int n) {
        // State: let dp[i] be the least number of perfect square nubmers that i can be formed
        // Recurrence: dp[i] = min(dp[i - j*j] + 1) for j = 1,2....i and j*j <= i
        
        int[] dp = new int[n + 1];
        
        //init
        dp[0] = 0;
    
        int i, j;
        for(i = 1 ; i <= n; ++i){
            dp[i] = Integer.MAX_VALUE;
            for(j = 1; j*j <= i; ++j){
                if(dp[i - j*j] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
                }
            }
        }
        
        return dp[n];
    }
}