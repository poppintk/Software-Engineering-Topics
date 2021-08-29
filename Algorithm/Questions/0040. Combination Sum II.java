class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return ans;
        Arrays.sort(candidates);    
        
        dfs(candidates, target, ans, new ArrayList<>(), 0);
        
        return ans;
    
    }
    
    private void dfs(int[] nums, int target, List<List<Integer>> ans, List<Integer> path, int from) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = from; i < nums.length; i++) {
            if (i != from && nums[i] == nums[i - 1]) continue;
            if (target - nums[i] < 0) continue;
            path.add(nums[i]);
            dfs(nums, target - nums[i], ans, path, i + 1);    
            path.remove(path.size() - 1);
        }
    }
    
    
}