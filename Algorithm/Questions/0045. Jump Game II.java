class Solution {
    /**
    * 1 <= nums.length <= 104
    * 0 <= nums[i] <= 1000
    */
    
    // version1 DP
    public int jump(int[] nums) {
        // let dp[i] be minmum step can jump to position i 
        // dp[i] = Math.min(dp[i], dp[j] + 1) if nums[j] + j >= i
        int n = nums.length;
        int[] dp = new int[n];
        
        dp[0] = 0;
        
        
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (nums[j] + j >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        
        return dp[n - 1];
    }
}


class Solution {
    /**
    * 1 <= nums.length <= 104
    * 0 <= nums[i] <= 1000
    */
    // greedy O(n)
    public int jump(int[] A) {
        int step = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < A.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + A[i]);
            if (i == curEnd) {
                step++;
                curEnd = curFarthest;
            }
        }
        return step;
    }
}