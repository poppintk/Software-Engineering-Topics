class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return -1;
        
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length;j++){
                if(grid[i][j] == 1) fresh++;
                if(grid[i][j] == 2) queue.add(new int[]{i,j});
            }
        }
        if(fresh == 0) return 0;
        
        int mins = 0;
        
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            int size = queue.size();
             if(fresh == 0) return mins; // goal
            for(int k = 0; k < size; k++){
                int[] cur = queue.poll();
                for(int[] dir: dirs){
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if(x < 0 || x == grid.length || y < 0 || y == grid[0].length || grid[x][y] != 1) continue;
                    grid[x][y] = 2;// want 1 -> 2 so grid[x][y] != 1
                    queue.add(new int[] {x,y});
                    fresh --;
                }
            }
            mins ++;
        }
        
        return -1;
        
    }
}