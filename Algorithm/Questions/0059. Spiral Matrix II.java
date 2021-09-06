public class Solution {
    public int[][] generateMatrix(int n) {
        // Declaration
        int[][] matrix = new int[n][n];
        
        // Edge Case
        if (n == 0) {
            return matrix;
        }
    
        
        int left = 0;
        int right = n - 1;
        int down = n - 1;
        int up = 0;
        int end = n * n;
        int k = 0;
        while (k < end) {
            for (int j = left; j <= right; j++) {
                matrix[up][j] = k + 1;
                k++;
            }
            up++;
            for (int i = up; i <= down; i++) {
                matrix[i][right] = k + 1;
                k++;
            }
            right--;
            for (int j = right; j >= left; j--) {
                matrix[down][j] = k + 1;
                k++;
            }
            down--;
            for (int i = down; i >= up; i--) {
                matrix[i][left] = k + 1;
                k++;
            }
            left++;
        }
        return matrix;
    }
}