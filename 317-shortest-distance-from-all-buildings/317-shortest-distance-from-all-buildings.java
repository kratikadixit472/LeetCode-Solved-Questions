class Solution {
    public int shortestDistance(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        
        int[][] dis = new int[n][m];
        
        int[][] reach = new int[n][m];
        
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        
        int totalBuildings = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                
                if(grid[i][j] == 1){
                    
                    totalBuildings++;
                    
                    boolean[][] vis = new boolean[n][m];
                    LinkedList<int[]> q = new LinkedList<>();
                    
                    q.add(new int[]{i, j});
                    vis[i][j] = true;
                    int distance = 1;
                    
                    while(!q.isEmpty()){
                        
                        int sz = q.size();
                        while(sz-- > 0){
                            int[] top = q.poll();
                            int r = top[0], c = top[1];

                            for(int[] d: dir){
                                int nr = r + d[0];
                                int nc = c + d[1];

                                if(nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 0 && !vis[nr][nc]){
                                    reach[nr][nc]++;
                                    dis[nr][nc] += distance;
                                    vis[nr][nc] = true;
                                    q.add(new int[]{nr, nc});
                                }
                            }
                        }
                        distance++;
                    }
                }
            }
        }
        
        int ans = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(reach[i][j] == totalBuildings){
                    ans = Math.min(ans, dis[i][j]);
                }
            }
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}