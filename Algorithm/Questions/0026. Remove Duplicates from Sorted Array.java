public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int preIdx = 0; // first unique item
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] != nums[i]) {
                preIdx++;
                nums[preIdx] = nums[i + 1];
            }
        }
        
        return preIdx + 1;
    }
