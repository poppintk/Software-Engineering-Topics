class Solution {
    public boolean canPartition(int[] nums) {
        // similar to 0/1 knapsack
        // this questions can apply 0/1 knapsack because if there exist a subset, then found such subset form a sum / 2, then another half subset can form a sum / 2 immediately
        // if partition into k sum then 0/1 knapsack is not longer hold 
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        // odd number can not divide into two equal subset
        if (sum % 2 != 0) return false;
        
        // convert into 0/1 backpack problem the weight is sum / 2;
        // let dp[i][j] be the first item from nums[0...i - 1] that can form a number j 
        // dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]]
        int n = nums.length;
        int target = sum / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];
        
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < target + 1; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = true;
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = false;
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = false;// NOTE: many item cannot form a 0 weight
                    continue;
                }
                
                dp[i][j] = dp[i - 1][j];
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        
        return dp[n][target];
    }
}