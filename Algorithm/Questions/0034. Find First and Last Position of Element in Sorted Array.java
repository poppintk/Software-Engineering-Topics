class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[] {-1, -1};
        if (nums == null || nums.length == 0) return ans;
        
        ans[0] = binarySearch(nums, target, true);
        ans[1] = binarySearch(nums, target, false);
        
        return ans;
    }
    
    private int binarySearch(int[] nums, int target, boolean isLower) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isLower) {
                if (nums[mid] < target) {
                    left = mid;
                } else {
                    right = mid;
                }
            } else {
                if (nums[mid] <= target) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        
        if (isLower) {
            if (nums[left] == target) return left;
            if (nums[right] == target) return right;
        } else {
            if (nums[right] == target) return right;
            if (nums[left] == target) return left;
        }
        
        return -1;
    }
}