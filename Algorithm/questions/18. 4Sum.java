class Solution {
    // 4 sum 暴力解O(2^n), TODO reduce to O(n^3) using two pointer
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        dfs(nums, target, ans, path, 0);
    
        return ans;
    }
    
    private void dfs(int[] nums, int target, List<List<Integer>> ans, List<Integer> path, int from) {
        if (target == 0 && path.size() == 4) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (path.size() > 4) return;
        for (int i = from; i < nums.length; i++) {
            if (i != from && nums[i - 1] == nums[i]) continue;
            path.add(nums[i]);
            dfs(nums, target - nums[i], ans, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}