class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        backtracking(ans, path, nums, 0);
        
        return ans;
    }
    
    private void backtracking(List<List<Integer>> ans, List<Integer> path, int[] nums, int from) {
        ans.add(new ArrayList<>(path));
        for (int i = from; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(ans, path, nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}