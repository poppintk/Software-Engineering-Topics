class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int preIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[preIdx] != nums[i]) {
                nums[++preIdx] = nums[i];
            }
        }
        
        return preIdx + 1;
    }
}