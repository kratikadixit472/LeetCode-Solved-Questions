class Solution {
    public int getFood(char[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        boolean[][] vis = new boolean[n][m];
        
        int starti = -1, startj = -1;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m ;j++){
                if(grid[i][j] == '*'){
                    starti = i; startj = j;
                    break;
                }
            }
        }
        
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{starti, startj, 0});
        vis[starti][startj] = true;
        
        while(!q.isEmpty()){
            int[] top = q.poll();
            
            int r = top[0], c = top[1], dist = top[2];
            
            if(grid[r][c] == '#') return dist;
            
            for(int[] d : dir){
                int nr = r + d[0];
                int nc = c + d[1];
                
                if(nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] != 'X' && !vis[nr][nc]){
                    q.add(new int[]{nr, nc, dist+1});
                    vis[nr][nc] = true;
                }
            }
        }
        return -1;
    }
}