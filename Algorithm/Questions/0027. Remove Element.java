class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        
        int idx = 0; // point to the last unremoved item
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[idx++] = nums[i]; // NOTE: when override occurs
            }
        }
        
        return idx;
    }
}