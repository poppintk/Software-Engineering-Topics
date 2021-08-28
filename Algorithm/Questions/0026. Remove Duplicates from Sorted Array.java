class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int preIdx = 0; // point to the last unique item
        for (int i = 0; i < nums.length; i++) {
            if (nums[preIdx] != nums[i]) {
                nums[++preIdx] = nums[i]; // Note: override value occurs after different values occurs
            }
        }
        
        return preIdx + 1;
    }
}