class Solution {
    public int shortestDistance(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        
        int[][] reach = new int[n][m];
        int[][] dist = new int[n][m];
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        int totalHouses = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < m; j++){
                if(grid[i][j] == 1){
                    totalHouses++;
                    
                    boolean[][] vis = new boolean[n][m];
                    LinkedList<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    int level = 1;
                    
                    while(!q.isEmpty()){
                        int sz = q.size();
                        while(sz-- > 0){
                            
                            int[] curr = q.poll();
                            int r = curr[0], c = curr[1];
                            
                            for(int d [] : dir){
                                int nr = r + d[0];
                                int nc = c + d[1];
                                
                                if(nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 0 && !vis[nr][nc]){
                                    dist[nr][nc] += level;
                                    reach[nr][nc]++;
                                    q.add(new int[]{nr, nc});
                                    vis[nr][nc] = true;
                                }
                            }
                        }
                        level++;
                    }
                }
            }
        }
        
        int minDist = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < m; j++){
                if(reach[i][j] == totalHouses){
                    minDist = Math.min(minDist, dist[i][j]);
                }
            }
        }
        
        return (minDist == Integer. MAX_VALUE)  ? -1 : minDist;
    }
}