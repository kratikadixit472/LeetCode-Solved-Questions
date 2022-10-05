class Solution {
    public int shortestPath(int[][] grid, int k) {
        
        int n = grid.length, m = grid[0].length;
        
        Queue<int[]> pq = new LinkedList<>();
        boolean[][][] vis = new boolean[n][m][k+1];
        
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        
        pq.add(new int[]{0, 0, 0, 0});
        vis[0][0][0] = true;
        
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            
            int r = top[0], c = top[1], steps = top[2], currK = top[3];
            
            if(r == n-1 && c == m-1) return steps;
            
            for(int[] d : dir){
                int nr = r + d[0];
                int nc = c + d[1];
                
                if(nr >= 0 && nc >= 0 && nr < n && nc < m){
                    
                    int nextK = currK + grid[nr][nc];
                    
                    if(nextK <= k && !vis[nr][nc][nextK]){
                        pq.add(new int[]{nr, nc, steps+1, nextK});
                        vis[nr][nc][nextK] = true;
                    }
                    
                }
            }
        }
        return -1;
    }
}