class Solution {
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        
        LinkedList<int[]> q = new LinkedList<>();
        int[][] seen = new int[n][m];
        
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                seen[i][j] = Integer.MAX_VALUE;
            }
        }
        q.add(new int[]{0, 0, 0});
        seen[0][0] = 0;
        int ans = 0;
       
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                
                int[] curr = q.poll(); 
                int i = curr[0], j = curr[1];
                
                if(i == n - 1 && j == m-1) return ans;
                
                for(int d[] : dir){
                    int r = i + d[0];
                    int c = j + d[1];
                    
                    if(r >= 0 && c >= 0 && r < n && c < m){
                        
                        int next = grid[i][j] + curr[2];
                       // System.out.println(r+" "+ c+" "+ next);
                        if(seen[r][c] <= next || next > k) continue;
                         
                        q.add(new int[]{r, c, next});
                        seen[r][c] = next;
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}