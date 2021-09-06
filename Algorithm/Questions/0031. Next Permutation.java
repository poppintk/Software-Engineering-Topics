class Solution {
    // [1,2,1,5,4,3,3,2,1] => [1,2,2,1,1,3,3,4,5]
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        
        
        // looping backwards and Finding i which breaking increasing sequence
        int i;
        for (i = nums.length - 1; i >= 0; i--) {
            if (i != nums.length - 1 && nums[i] < nums[i + 1]) break; // Note: watch out for duplcates
        }

        if (i == -1) {
            reverseSort(nums, 0, nums.length - 1); // edge case: [3, 2, 1] => [1, 2, 3]
            return;
        }
        
        // looping backwards start from end to i + 1, and finding nums[j] > nums[i]
        int j = 0;
        for (j = nums.length - 1; j > i; j--) {
            if (nums[j] > nums[i]) { // Note: watch out for duplcates, first one from the backward travasal 
                break;
            }
        }

        // swap
        swap(nums, j, i);
        // reverse order from i to the end
        reverseSort(nums, i + 1, nums.length - 1);
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverseSort(int[] nums, int start, int end){   
        if(start > end)
            return;
        for(int i = start; i <= (end+start)/2; i++)
            swap(nums, i, start + end - i);
    }
}