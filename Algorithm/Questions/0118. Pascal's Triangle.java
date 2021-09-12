class Solution {
    // matrix[i][j] = matrix[i - 1][j] + matrix[i - 1][j - 1]
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans  = new ArrayList<>();
        if (numRows == 0){
            return ans;
        } 
        if (numRows == 1) {
            ans.add(Arrays.asList(1));
            return ans;
        }
        ans.add(Arrays.asList(1));
        ans.add(Arrays.asList(1, 1));
        
        for (int i = 2; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            int size = ans.size();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    temp.add(ans.get(size - 1).get(j - 1) + ans.get(size - 1).get(j));
                }
            }
            ans.add(temp);
        }
        
        
        return ans;
    }
}
