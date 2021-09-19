class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    
    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        
        int mid = left + (right - left) / 2;
        int pivot = nums[mid];
        
        // partition
        int start = left;
        int end = right;
        while (start <= end) {
            while (start <= end && nums[start] < pivot) start++;
            while (start <= end && nums[end] > pivot) end--;
            if (start <= end) {
                // swap
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
        
        // [left , end] [end, start] [start, right]
        
        quickSort(nums, left, end);
        quickSort(nums, start, right);
    }
    
    
    
    
    
    private int[] mergeSort(int[] nums, int left, int right) {
        if (left >= right) return new int[] {nums[left]};
        // divide
        int mid = left + (right - left) / 2;
        int[] leftArr = mergeSort(nums, left, mid);
        int[] rightArr = mergeSort(nums, mid + 1, right);
        return merge(leftArr, rightArr);
    }
    
    private int[] merge(int[] left, int[] right) {
        int lSize = left.length;
        int rSize = right.length;
        int[] ans = new int[lSize + rSize];
        
        int i = 0;
        int l = 0;
        int r = 0;
        
        while (l < lSize && r < rSize) {
            if (left[l] < right[r]) {
                ans[i] = left[l];
                i++;
                l++;
            } else {
                ans[i] = right[r];
                i++;
                r++;
            }
        }
        
        while (l < lSize) {
            ans[i] = left[l];
            i++;
            l++;
        }
        
        while (r < rSize) {
            ans[i] = right[r];
            i++;
            r++;
        }
        
        return ans;
    }
}