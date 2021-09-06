class Solution {
    // native O(m + n) Space and O(m*n) time
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
        
    }
}


    /**
    *
    
    1 0 1    0 0 0
    1 1 1 => 1 0 1   becarful here for matrix[0][0] = 0 might come from the row or col
    1 1 1    1 0 1
    
    */
class Solution {
    public void setZeroes(int[][] matrix) {
        Boolean isCol = false;
        int m = matrix.length;
        int n = matrix[0].length;
        
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                isCol = true;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // See if the first row needs to be set to zero as well
        if (matrix[0][0] == 0) {
          for (int j = 0; j < n; j++) {
            matrix[0][j] = 0;
          }
        }

        // See if the first column needs to be set to zero as well
        if (isCol) {
          for (int i = 0; i < m; i++) {
            matrix[i][0] = 0;
          }
        }
        
    }
}