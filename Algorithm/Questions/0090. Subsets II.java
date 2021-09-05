/*
*
    nums.length <= 10
    -10 <= nums[i] <= 10
*/
// O(2 ^ n)
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        backtracking(nums, ans, path, 0);
        
        return ans;
    }
    
    private void backtracking(int[] nums, List<List<Integer>> ans, List<Integer> path, int from) {
        ans.add(new ArrayList<>(path));
        for (int i = from; i < nums.length; i++) {
            if (i != from && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            backtracking(nums, ans, path, i + 1);
            path.remove(path.size() - 1);
        }
        
    }
}