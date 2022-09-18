class Solution {
    public int largestIsland(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        
        int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        boolean[][] vis = new boolean[n][m];
        
        int color = 2;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    int size = DFS(i, j, grid, color, dir, n, m);
                    map.put(color, size);
                    color++;
                }
            }
        }
        
        int largeIsland = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0){
                    
                    Set<Integer> set = new HashSet<>();
                    
                    set.add((i > 0) ? grid[i-1][j] : 0);
                    set.add((j > 0) ? grid[i][j-1] : 0);
                    set.add((i < n-1) ? grid[i+1][j] : 0);
                    set.add((j < m-1) ? grid[i][j+1] : 0);
                    
                    int newSize = 1;
                    for(int id : set) newSize += map.get(id);
                    largeIsland = Math.max(largeIsland, newSize);
                }
            }
        }
        return largeIsland == 0 ? n * m : largeIsland;
    }
    
    private int DFS(int i, int j, int[][] grid, int color, int[][] dir, int n, int m){
        
        grid[i][j] = color;
        int cnt = 1;
        
        for(int[] d : dir){
            int r = i + d[0];
            int c = j + d[1];
            
            if(r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 1){
                cnt += DFS(r, c, grid, color, dir, n, m);
            }
        }
        return cnt;
    }
}