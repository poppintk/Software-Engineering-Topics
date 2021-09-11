class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length == 1) return nums[0] == target;
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == nums[left]) {  // NOTE
                left++;
            } else if (nums[mid] == nums[right]) {  // NOTE
                right--;
            } 
            // find which part is currently in
            else if (nums[0] < nums[mid]) { // on left size
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else if (nums[0] > nums[mid]) {
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }

        if (nums[left] == target) return true;
        if (nums[right] == target) return true;
        return false;
    }
}
