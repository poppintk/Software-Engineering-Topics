class Solution {
    public boolean canJump(int[] nums) {
        // let dp[i] be whether can jump to index i
        // dp[i] =dp[j] && j + nums[j] >= i for 0 <= j < i
        
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && nums[j] + j >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[n - 1];
    }
}

class Solution {
    public boolean canJump(int[] nums) {
        
        int curEnd = 0, furthest = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            furthest = Math.max(furthest, i + nums[i]);
            if (i == curEnd) {
                curEnd = furthest;
            }
        }
        return curEnd >= nums.length - 1;
    }
}