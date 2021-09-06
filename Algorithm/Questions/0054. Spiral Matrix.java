class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int colStart = 0;
        int colEnd = n - 1;
        int rowStart = 0;
        int rowEnd = m - 1;
        
        int end = m * n;
        int start = 0;
        List<Integer> ans = new ArrayList<>();
        while (start < end) {
            for (int i = colStart; start < end && i <= colEnd; i++) {
                ans.add(matrix[rowStart][i]);
                start++;
            }
            rowStart++;
            for (int i = rowStart; start < end && i <= rowEnd; i++) {
                ans.add(matrix[i][colEnd]);
                start++;
            }
            colEnd--;
            for (int i = colEnd; start < end && i >= colStart; i--) {
                ans.add(matrix[rowEnd][i]);
                start++;
            }
            rowEnd--;
            for (int i = rowEnd; start < end && i >= rowStart; i--) {
                ans.add(matrix[i][colStart]);
                start++;
            }
            colStart++;
        }
        return ans;
    }
}