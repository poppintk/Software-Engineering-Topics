class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        int left = 0;
        int right = nums.length - 1;
        int lastNum = nums[nums.length - 1]; // why not choose first number? because if array is increasing order it will fail!
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == nums[left]) {
                left++;
            } else if (nums[mid] == nums[right]) {
                right--;
            }
            else if (nums[mid] > lastNum) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if (nums[right] < nums[left]) return nums[right];
        return nums[left];
    }
}