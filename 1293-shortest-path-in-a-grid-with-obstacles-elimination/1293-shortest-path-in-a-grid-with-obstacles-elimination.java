class Solution {
    public int shortestPath(int[][] grid, int k) {
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        
        int n = grid.length, m = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{0, 0, 0, 0});
        int[][] vis = new int[n][m];
        
        for(int v[] : vis){
            Arrays.fill(v, Integer.MAX_VALUE);
        }
        
        vis[0][0] = 0;
        
        while(!q.isEmpty()){
            
            int[] top = q.poll();
            int i = top[0], j = top[1];
            int currK = top[2], dis = top[3];
            
            // System.out.println(i+" "+ j+" "+ currK+" "+ dis);
            
            if(i == n-1 && j == m-1) return dis;
            
            for(int[] d: dir){
                int r = i + d[0];
                int c = j + d[1];
                
                if(r >= 0 && c >= 0 && r < n && c < m){
                    
                    int newK = currK + grid[r][c];
                    
                    if(currK <= k && vis[r][c] > newK){
                        vis[r][c] = newK;
                        q.add(new int[]{r, c, newK, dis+1});
                    }
                    
                }
            }
        }
        return -1;
    }
}