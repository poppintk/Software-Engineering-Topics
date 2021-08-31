class Solution {
    boolean[] col = null;
    boolean[] dig1 = null;
    boolean[] dig2 = null;
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        if (n == 0) return ans;
        
        char[][] board = init(n);
    
        backtracking(ans, 0, board);
        
        return ans;
        
    }
    
    private void backtracking(List<List<String>> ans, int i, char[][] board) {
        if (i == board.length) {
            ans.add(convertBoard(board));
            return;
        }
        
        for (int j = 0 ; j < board.length; j++) {
            if (board[i][j] != '.') continue;
            if (!isValid(board, i, j)) continue;
            makeMove(board, i, j);
            backtracking(ans, i + 1, board);
            undoMove(board, i, j);
            
        }
    }
    
    private boolean isValid(char[][] board, int i, int j) {
        int n = board.length;
        return !col[j] && !dig1[i + j] && !dig2[j - i + n - 1];
    }
    
    private void makeMove(char[][] board, int i, int j) {
        board[i][j] = 'Q';
        int n = board.length;
        col[j] = true;
        dig1[i + j] = true;
        dig2[j - i + n - 1] = true;
    }
    
    private void undoMove(char[][] board, int i, int j) {
        board[i][j] = '.';
        int n = board.length;
        col[j] = false;
        dig1[i + j] = false;
        dig2[j - i + n - 1] = false;
    }
    
    private List<String> convertBoard(char[][] board) {
        List<String> res = new ArrayList<>();
        int n = board.length;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
            res.add(sb.toString());
        }
        return res;
    }
    
    private char[][] init(int n) {
        char[][] board = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        col = new boolean[n];
        dig1 = new boolean[2 * n - 1];
        dig2 = new boolean[2 * n - 1];
        
        return board;
    }
}