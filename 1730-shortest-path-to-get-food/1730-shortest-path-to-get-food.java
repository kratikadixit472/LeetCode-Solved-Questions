class Solution {
    public int getFood(char[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        LinkedList<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '*'){
                    q.add(new int[]{i, j});
                    vis[i][j] = true;
                    break;
                }
            }
        }
        
        int distance = 0;
        
        while(!q.isEmpty()){
            
            int sz = q.size();
            while(sz-- > 0){
                int[] top = q.poll();
                
                int i = top[0], j = top[1];
                if(grid[i][j] == '#') return distance;
                
                for(int[] d : dir){
                    int r = i + d[0];
                    int c = j + d[1];
                    
                    if(r >= 0 && c >= 0 && r < n && c < m && !vis[r][c] && grid[r][c] != 'X'){
                        vis[r][c] = true;
                        q.add(new int[]{r, c});
                    }
                }
            }
            distance++;
        }
        return -1;
    }
}