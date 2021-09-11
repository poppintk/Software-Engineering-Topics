class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int preIdx = 0; // first unique item
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i - 1] != nums[i]) {
                preIdx++;
                nums[preIdx] = nums[i];
            }
        }
        
        return preIdx + 1;
    }
}
