class Solution {
    // O((MN) * (MN))
    private int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        if (board[0] == null || board[0].length == 0) return false;
        
        int n = board.length;
        int m = board[0].length;
    
        
        boolean[][] visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true; // NOTE
                if (backTracking(visited, board, word, 0, i, j)) return true;
                visited[i][j] = false;
            }
        }
        
        return false;
    }
    
    
    
    private boolean backTracking(boolean[][] visited, char[][] board, String word, int index, int i, int j) {
        if (word.length() - 1 == index && word.charAt(index) == board[i][j]) return true; //NOTE
        if (word.charAt(index) != board[i][j]) return false;
        
        for (int[] dir : DIRS) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (!isValid(x, y, board, word)) continue;
            
            if (visited[x][y]) continue;
            visited[x][y] = true;  // NOTE
            if (backTracking(visited, board, word, index + 1, x, y)) return true;
            visited[x][y] = false;
        }
        
        return false;
    }
    
    private boolean isValid(int x, int y, char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        if (x < 0 || x >= n) return false;
        if (y < 0 || y >= m) return false;
        return true;
    }
}
