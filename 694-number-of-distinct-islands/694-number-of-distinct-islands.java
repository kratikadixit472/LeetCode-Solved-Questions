class Solution {
    public int numDistinctIslands(int[][] grid) {
        
        Set<String> set = new HashSet<>();
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0,1}};
        
        String[] dir_str = {"u", "l", "d", "r"};
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1){
                    
                    StringBuilder sb = new StringBuilder();
                    sb.append("s");
                    dfs_distinct(grid, i, j, dir, dir_str, sb);
                    set.add(sb.toString());
                    System.out.print(sb.toString() +" ");
                    
                }
            }
        }
        return set.size();
    }
    
    private void dfs_distinct(int[][] grid, int i, int j, int[][] dir, String[] dir_str, StringBuilder sb){
        
        grid[i][j] = 0;
        
        for(int d = 0;  d < 4; d++){
            int x = i + dir[d][0];
            int y = j + dir[d][1];
            
            if(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 1){
                dfs_distinct(grid, x, y, dir, dir_str, sb.append(dir_str[d]));
            }
            if(d == 3) sb.append("e");
        }
    }
}