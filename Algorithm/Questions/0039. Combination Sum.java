class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return ans;
        
        List<Integer> path = new ArrayList<>();
        
        dfs(candidates, target, ans, path, 0);
        
        return ans;
    }
    
    private void dfs(int[] nums, int target, List<List<Integer>> ans, List<Integer> path, int from) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
        }
        
        
        for (int i = from; i < nums.length; i++) {
            if (target - nums[i] < 0) continue;
            
            path.add(nums[i]);
            dfs(nums, target - nums[i], ans, path, i);
            path.remove(path.size() - 1);
        }
        
        
    }
}