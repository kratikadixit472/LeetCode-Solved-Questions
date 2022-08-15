class Solution {
    public int maxDistance(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        LinkedList<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1) q.add(new int[]{i, j});
            }
        }
        
        int dist = 0;
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        
        if(q.size()==0 || q.size()==m*n ) return -1;
        
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                int[] curr = q.poll();
                
                for(int[] d : dir){
                    int r = curr[0] + d[0];
                    int c = curr[1] + d[1];
                    
                    if(r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 0){
                        grid[r][c] = 1;
                        q.offer(new int[]{r, c});
                    }
                }
            }
            dist++;
        }
        
        return dist-1;
    }
}