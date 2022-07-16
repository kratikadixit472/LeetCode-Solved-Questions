class Solution {
    public int maxDistance(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        
        boolean[][] vis = new boolean[n][m];
        
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        LinkedList<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m ; j++){
                if(grid[i][j] == 1) q.add(new int[] {i, j});
                //vis[i][j] = true;
            }
        }
        
        if(q.size() == n * m) return -1;
        
        int distance = 0;
        
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                int[] top = q.poll();
                int i = top[0];
                int j = top[1];
                
                for(int[] d : dir){
                    int r = i + d[0];
                    int c = j + d[1];
                    
                    if(r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 0){
                        q.add(new int[]{r, c});
                        vis[r][c] = true;
                        grid[r][c] = 1;
                    }
                }
            }
            distance++;
        }
        return distance - 1;
    }
}