class Solution {
    public int maxSubArray(int[] nums) {
        // let dp[i] be the maximum contiguous value ending at i
        // dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        // This DP similar to Longest increasing sbusequence
        // LIS question dp[i] is LIS ending at index i. dp[i] = Math.max(dp[i], dp[j] + 1)
        // difference: sequence is not continous and this question is continous
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        
        dp[0] = nums[0];
        int max = dp[0];
        
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]); // continous not require looping j -> 0 - i dp[j], where just take dp[i - 1]
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}