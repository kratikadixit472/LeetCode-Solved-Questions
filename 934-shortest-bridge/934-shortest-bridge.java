class Solution {
    
    //int count = 0;
    
    public int shortestBridge(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        
        LinkedList<int[]> q = new LinkedList<>();
        int[][] dir = {{-1, 0} ,{0, -1}, {1, 0}, {0, 1}};
        
        boolean found = false;
        
        for(int i = 0; i < n; i++){
            if(found) break;
            for(int j = 0 ; j < m; j++){
                if(grid[i][j] == 1) {
                    q.add(new int[]{i, j});
                    found = true;
                    DFS(i, j, n, m, grid, q, dir);
                    break;
                }
            }
        }
       // System.out.println(count);
        int shortest = 0;
        
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                int[] top = q.poll();

                for(int[] d : dir){
                    int r = top[0] + d[0];
                    int c = top[1] + d[1];

                    if(r >= 0 && c >= 0 && r < n && c < m){
                        if(grid[r][c] == 1) return shortest;

                        if(grid[r][c] == 0){
                           // System.out.print(r+" "+c+",  ");
                            grid[r][c] = 2;
                            q.add(new int[]{r, c});
                        }
                    }
                }
            }
          //  System.out.println();
            shortest++;
        }
        return shortest;
    }
    
    private void DFS(int i, int j, int n, int m, int[][] grid, LinkedList<int[]> q, int[][] dir){
        
        grid[i][j] = 2;
        
        for(int[] d : dir){
            int r = i + d[0];
            int c = j + d[1];
            
            if(r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 1){
                //count++;
              //  System.out.println(r+" "+c);
                DFS(r, c, n, m, grid, q, dir);
                q.add(new int[]{r, c});
            }
        }
    }
}