class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        if (matrix[0] == null || matrix[0].length == 0) return false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int left = 0;
        int right = n * m - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            int i = mid / n;
            int j = mid % n;
            
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        if (matrix[left / n][left % n] == target) return true;
        if (matrix[right / n][right % n] == target) return true;
        
        
        return false;
    }
}