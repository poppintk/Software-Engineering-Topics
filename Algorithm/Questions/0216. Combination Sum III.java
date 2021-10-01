class Solution {
    //  The list must not contain the same combination twice, and the combinations may be returned in any order.
    // i.e. [1,2,4] == [4,2,1]
    // NOTE: each number is used at most once
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(ans, path, k, n, 1, 0);
        return ans;
    }
    
    private void backtracking(List<List<Integer>> ans, List<Integer> path, int k, int n, int from, int sum) {
        if (path.size() == k) {
            if (sum == n) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }        
        for (int i = from; i <= 9; i++) {
            path.add(i);
            backtracking(ans, path, k, n, i + 1, sum + i);
            path.remove(path.size() - 1);
        }
    }
}