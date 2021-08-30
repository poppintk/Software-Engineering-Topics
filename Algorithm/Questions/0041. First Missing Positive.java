class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        
        // in place sort, move number in place for numbers in [1, nums.length], note first element is 1(NOT 0)
        int i = 0;
        while(i < nums.length){
          if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) { // WHY nums[i] != nums[i - 1] NOT nums[i] - 1 != i ? 
            swap(nums,i, nums[i] - 1);
          }else{
            i++;
          }
        }
        // ALTERNATIVELY
        // while (i < nums.length) {
        //     if (nums[i] > 0 && nums[i] <= nums.length && nums[i] - 1 != i) {
        //         int old = nums[i];
        //         swap(nums, i, nums[i] - 1);
        //         if (old == nums[i]) i++; // FOR DUPLICATE
        //     } else {
        //         i++;
        //     }
        // }
        //System.out.println(Arrays.toString(nums));
        int j = 0;
        for (j = 0; j < nums.length; j++) {
            if (nums[j] - 1 != j) return j + 1;
        }
        
        return j + 1;

    }
    
    public void swap(int[] nums, int i , int j){
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
  }
}