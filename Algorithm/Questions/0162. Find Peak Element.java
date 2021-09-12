class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) return 0;
        
        int left = 0, right = nums.length - 1;
        
        // nums[mid - 1] < nums[mid] > nums[mid + 1]
        while (left  + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= nums[mid - 1]) {
                right = mid;
            } else if (nums[mid] <= nums[mid + 1]) {
                left = mid;
            } else {
                return mid;
            }
        }
        
        if (nums[left] < nums[right]) return right;
        return left;
    }
}