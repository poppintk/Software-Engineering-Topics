class Solution {
    /**
    *Constraints:
    *   matrix.length == n
    *   matrix[i].length == n
    *  1 <= n <= 20
    * -1000 <= matrix[i][j] <= 1000
    */
    public void rotate(int[][] matrix) {
        /**
        *  1 2 3               1 4 7                                              7 4 1
           4 5 6  transpose => 2 5 8   swaping start and end index for each row=> 8 5 2
           7 8 9               3 6 9                                              9 6 3
        */
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        // swap matrix[i][j] and matrix[j][i]
        for (int i = 0; i < m; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // two pointer swap left and right for each row in matrix
        for (int i = 0; i < m; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
        
    }
}