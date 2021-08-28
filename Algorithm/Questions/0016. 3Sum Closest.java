class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        
        Arrays.sort(nums);
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (Math.abs(sum - target) < min) {
                    min = Math.abs(sum - target);
                    ans = sum;
                }
                if (sum == target) return target;
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        
        return ans;
    }

}