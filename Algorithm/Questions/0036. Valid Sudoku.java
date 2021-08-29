class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> box = new HashMap<>();
        Map<Integer, Set<Character>> row = new HashMap<>();
        Map<Integer, Set<Character>> col = new HashMap<>();
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
                if (row.get(i).contains(c) || col.get(j).contains(c) || box.get((i / 3) * 3 + j / 3).contains(c)) {
                    return false;
                } else {
                    row.get(i).add(c);
                    col.get(j).add(c);
                    box.get((i / 3) * 3 + j / 3).add(c);
                }
            }
        }
        
        return true;
        
        
    }
}