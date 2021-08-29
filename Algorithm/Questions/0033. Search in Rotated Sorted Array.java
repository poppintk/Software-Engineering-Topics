class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[0]) { // left half of rotation 
                if (nums[left] <= target && target <= nums[mid]) { // gurrantee [left, mid] is increasing interval
                    right = mid;
                } else {
                    left = mid;
                }
            } else { // right half of rotation [mid, right]
                if (nums[right] >= target && target >= nums[mid]) { // gurrantee [mid, right] is increasing interval
                    left = mid;
                } else {
                    right = mid;
                }
            }
            
        }
        
        
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;
        
    }
}