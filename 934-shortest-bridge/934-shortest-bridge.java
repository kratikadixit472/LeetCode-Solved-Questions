class Solution {
    
    LinkedList<int[]> q = new LinkedList<>();
    public int shortestBridge(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        boolean found = false;
        
        for(int i = 0; i < n; i++){
            if(found) break;
            for(int j = 0 ; j < m ; j++){
                
                if(grid[i][j] == 1){
                    q.add(new int[]{i, j});
                    DFS(i, j, n, m, grid, dir);
                    found = true;
                    break;
                }
            }
        }
        
        int step = 0;
        
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                int[] curr = q.poll();
                int i = curr[0], j = curr[1];
                // System.out.print(i + " "+ j +", ");
                for(int[] d : dir){

                    int r = i + d[0];
                    int c = j + d[1];

                    if(r >= 0 && c >= 0 && r < n && c < m){
                        
                        if(grid[r][c] == 1) {
                            //System.out.println("int");
                            return step;
                        }
                        
                        if(grid[r][c] == 0){
                            grid[r][c] = 2;
                            q.add(new int[]{r, c});
                        }
                    }
                }
                
            }
            // System.out.println("out");
            step++;
        }
        return step;
    }
    
    private void DFS(int i, int j, int n, int m, int[][] grid, int[][] dir){
        
        grid[i][j] = 2;
        for(int[] d : dir){
            
            int r = i + d[0];
            int c = j + d[1];
            
            if(r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 1){
                DFS(r, c, n, m, grid, dir);
                q.add(new int[]{r, c});
            }
        }
    }
}