class Solution {
    public int minCost(int[][] grid) {
        
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        int n = grid.length, m = grid[0].length;
        
        LinkedList<int[]> q = new LinkedList<>();
        int[][] dist = new int[n][m];
        for(int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        
        q.add(new int[]{0, 0, 0});
        dist[0][0] = 0;
        
        while(!q.isEmpty()){
            
            int[] top = q.poll();
            
            int cost = top[0], r = top[1], c = top[2];
            
            if(dist[r][c] != cost) continue;
            
            for(int i = 0; i < 4; i++){
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                
                if(nr >= 0 && nc >= 0 && nr < n && nc < m){
                    int nCost = cost;
                    if(i != grid[r][c]-1) {
                        nCost += 1;
                    }
                    
                    if(dist[nr][nc] > nCost){
                        dist[nr][nc] = nCost;
                        q.add(new int[]{nCost, nr, nc});
                    }
                }
            }
        }
        
        return dist[n-1][m-1];
    }
}