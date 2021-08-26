class Solution {
    // 4 sum 暴力解O(2^n), 
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
// reduce to O(n^3) using divide and conquer
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        
        Arrays.sort(nums);
        return kSum(nums, target, 4 ,0);

    }
    
    // divide and conque
    private List<List<Integer>> kSum(int[] nums, int target, int k, int from) {
        List<List<Integer>> res = new ArrayList<>();
        if (from == nums.length) return res;
        
        if (k == 2) {
            return twoSum(nums, target, from);
        }
        
        
        for (int i = from; i < nums.length; i++) {
            if (i != from && nums[i - 1] == nums[i]) continue;
            if (nums[from] * k > target || target > nums[nums.length - 1] * k) continue;
            
            for (List<Integer> sub : kSum(nums, target - nums[i], k - 1, i + 1)) {
                res.add(new ArrayList<>(Arrays.asList(nums[i])));
                res.get(res.size() - 1).addAll(sub);
            }
        }
        return res;
    }
    
    private List<List<Integer>> twoSum(int[] nums, int target, int from) {
        List<List<Integer>> res = new ArrayList<>();
        
        int left = from;
        int right = nums.length - 1;
        
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                res.add(Arrays.asList(nums[left], nums[right]));
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]) left++;
            }
            else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }
}