class Solution {
    // similar to 53 Maximum Subarray
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] max = new int[2];
        int[] min = new int[2];

        max[0] = nums[0];
        min[0] = nums[0];
        int ans = max[0];
        for (int i = 1; i < nums.length; i++) {
            max[i % 2] = Math.max(nums[i], Math.max(min[(i - 1) % 2] * nums[i], max[(i - 1) % 2] * nums[i]));
            min[i % 2] = Math.min(nums[i], Math.min(min[(i - 1) % 2] * nums[i], max[(i - 1) % 2] * nums[i]));
            ans = Math.max(ans, max[i % 2]);
        }
        return ans;
    }
}