class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 416 partition two equal sum
        int sum = 0;
        for (int n : nums) { sum += n;}
        // if cannot divide by 4 then cannot partition into k subsets
        if (sum % k != 0) return false;
        
        if (nums.length < k) return false;
        int target = sum / k;
		boolean res = canPartition(nums, new boolean[nums.length], 0, k, 0, target);
        return res;
    }
    
    private boolean canPartition(int[] nums, boolean[] used, int start, int k, int curSum, int target) {
		if (k == 0) {
            return true;
        }
		if (curSum > target) return false;
		if (curSum == target) return canPartition(nums, used, 0, k - 1, 0, target);// why reset start to 0? because combination might be anywhere in the array

		for (int i = start; i < nums.length; i++) { 
			if (used[i]) continue; // due to reset start to 0, it require array to keep tracking what already seen
			used[i] = true;
			if (canPartition(nums, used, i + 1, k, curSum + nums[i], target)) return true;
			used[i] = false;
		}

		return false;
	}
}