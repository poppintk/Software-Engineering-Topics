class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            twoSum(left, right, nums, i, ans);
        }
        return ans;
        
    }
    
    private void twoSum(int left, int right, int[] nums, int i, List<List<Integer>> ans) {
        while (left < right) {
            int sum = nums[left] + nums[right] + nums[i];
            if (sum == 0) {
                ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]) left++;
            }
            else if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }
    }
}