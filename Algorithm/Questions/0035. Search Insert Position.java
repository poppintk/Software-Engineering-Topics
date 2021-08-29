class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        if (nums[nums.length - 1] < target) return nums.length;
        if (nums[0] >= target) return 0;
        
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        if (nums[left] <= target) return right;
        if (nums[right] <= target) return left;
        
        return -1;
    }
}