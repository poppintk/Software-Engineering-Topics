class Solution {
    Map<Integer, Set<Character>> box = new HashMap<>();
    Map<Integer, Set<Character>> col = new HashMap<>();
    Map<Integer, Set<Character>> row = new HashMap<>();
    
    public void solveSudoku(char[][] board) {
        init(board);
        backTracking(board, 0);
    }
    
    private boolean backTracking(char[][] board, int row) { // pass row as fromIndex to speed up
        for (int i = row; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') continue;
                for (char n = '1'; n <= '9'; n++) {
                    if (!valid(board, i, j, n)) continue;
                    makeMove(board, i, j, n);
                    if (backTracking(board, i)) return true;
                    undoMove(board, i, j, n);
                }
                return false; // NOTE: after try all 1 to 9, if there is not a solution then return false
            }
        }
        
        return true;
    }
    
    private boolean valid(char[][] board, int i, int j, char c) {
        return !box.get((i / 3) * 3 + j / 3).contains(c) && 
            !row.get(i).contains(c) &&
            !col.get(j).contains(c);
    }
    
    private void makeMove(char[][] board, int i, int j, char c) {
        board[i][j] = c;
        row.get(i).add(c);
        col.get(j).add(c);
        box.get((i / 3) * 3 + j / 3).add(c);
    }
    
    private void undoMove(char[][] board, int i, int j, char c) {
        board[i][j] = '.';
        row.get(i).remove(c);
        col.get(j).remove(c);
        box.get((i / 3) * 3 + j / 3).remove(c);
    }
    
    
    private void init(char[][] board) {
        int size = board.length;
        for (int i = 0; i < size; i++) {
            box.put(i, new HashSet<>());
            row.put(i, new HashSet<>());
            col.put(i, new HashSet<>());
        }
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                box.get((i / 3) * 3 + j / 3).add(c);
                row.get(i).add(c);
                col.get(j).add(c);
            }
        }
        
    }
}

//version 2

class Solution {
    Set<Character>[] rows = new Set[9];
    Set<Character>[] cols = new Set[9];
    Set<Character>[] boxes = new Set[9];
    
    
    public void solveSudoku(char[][] board) {
        // initialize
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length;j++){
                if(rows[i] == null) rows[i] = new HashSet();
                if(cols[j] == null) cols[j] = new HashSet();
                if(boxes[(i/3)*3 + j/3] == null) boxes[(i/3)*3 + j/3] = new HashSet();
                
                if(board[i][j] != '.'){
                    rows[i].add(board[i][j]);
                    cols[j].add(board[i][j]);
                    boxes[(i/3)*3 + j/3].add(board[i][j]);
                }
            }
        }
        
        solve(board,0,0);
    }
    
    public boolean solve(char[][] board, int row, int col){
        if(row == board.length) return true;
        
        int nextCol = (col + 1) % board.length;
        int nextRow = col + 1 == board.length ? row + 1 : row; 
        
        if(board[row][col] != '.') return solve(board,nextRow,nextCol);
        
        for(char c = '1'; c <= '9'; c++){
            if(isValid(board,row,col,c)){
                rows[row].add(c);
                cols[col].add(c);
                boxes[(row/3)*3 + col/3].add(c);
                board[row][col] = c;
                if(solve(board,nextRow,nextCol)) return true;
                rows[row].remove(c);
                cols[col].remove(c);
                boxes[(row/3)*3 + col/3].remove(c);
                board[row][col] = '.';
            }
        
        }
        // after try all 1 to 9, if there is not a solution then return false
        return false;
    }
    
     private boolean isValid(char[][] board, int row, int col, char c){
         return !rows[row].contains(c) 
             && !cols[col].contains(c) 
             && !boxes[(row/3)*3 + col/3].contains(c);
    }
}