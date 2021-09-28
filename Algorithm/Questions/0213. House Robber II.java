class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int[] dp1 = new int[n + 1];
        int[] dp2 = new int[n + 1];
        
        // 1, n
        dp1[0] = 0;
        dp1[1] = 0; // NOTE, first index 0, 1 is zero, because start from 1
        for (int i = 2; i <= n; ++i) {
            dp1[i] = Math.max(dp1[i - 2] + nums[i - 1], dp1[i - 1]);
        }
                   
        // 0, n - 1
        dp2[0] = 0;
        dp2[1] = nums[0]; // NOTE, index 1 is nums[0], because start from 0
        for (int i = 2; i < n; ++i) { // NOTE stop at n - 1
            dp2[i] = Math.max(dp2[i - 2] + nums[i - 1], dp2[i - 1]);
        }

        return Math.max(dp1[n], dp2[n - 1]);
    }
    
}