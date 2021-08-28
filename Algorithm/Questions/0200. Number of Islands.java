class Solution {
    private char ISLAND = '1';
    private char WATER = '0';
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        if (grid[0] == null || grid[0].length == 0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][] visited = new boolean[m][n];
        
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == ISLAND && !visited[i][j]) {
                    bfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private int[][] DIRS = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private void bfs(char[][] grid, boolean[][] visited, int i, int j) {
        visited[i][j] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        
        while (!queue.isEmpty()) {
            int[] coor = queue.poll();
            for (int[] dir : DIRS) {
                int x = coor[0] + dir[0];
                int y = coor[1] + dir[1];
                if (!isValid(grid, x, y)) continue;
                if (visited[x][y]) continue;
                visited[x][y] = true;
                queue.add(new int[]{x, y});
            }
        }
    }
    
    private boolean isValid(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return false;
        return grid[x][y] == ISLAND;
    }
}