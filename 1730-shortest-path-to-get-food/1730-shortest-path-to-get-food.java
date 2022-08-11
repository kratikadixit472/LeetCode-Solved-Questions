class Solution {
    public int getFood(char[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        
        LinkedList<int[]> q = new LinkedList<>();
        
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '*'){
                    q.add(new int[]{i, j});
                }
            }
        }
        
        int ans = 1;
        
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                
                int[] curr = q.poll();
                //System.out.println(curr[0]+" "+ curr[1]+" "+ grid[curr[0]][curr[1]]+", ");
                
                if(grid[curr[0]][curr[1]] == '#') return ans;
                
                for(int d[] : dir){
                    int r = curr[0] + d[0];
                    int c = curr[1] + d[1];
                  // System.out.println("entered  "+ r +" "+ c+" ");
                    
                    if(r >= 0 && c >= 0 && r < n && c < m && grid[r][c] != 'X'){
                        
                        if(grid[r][c] == '#') return ans;
                        
                        q.add(new int[]{r, c});
                        grid[r][c] = 'X';
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}