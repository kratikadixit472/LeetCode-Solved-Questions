class Solution {
    public int getFood(char[][] grid) {
        
        LinkedList<int[]> q = new LinkedList<>();
        int[][] dir = {{-1,0}, {0,-1}, {1,0}, {0,1}};
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '*'){
                    q.add(new int[]{i, j});
                    break;
                }
            }
        }
        
        int step = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                int[] rvtx = q.poll();
                
                for(int d = 0 ; d < 4; d++){
                    int r = rvtx[0] + dir[d][0];
                    int c = rvtx[1] + dir[d][1];
                    
                    if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 'X') continue;
                    if(grid[r][c] == '#') return step + 1;
                    
                    grid[r][c] = 'X';
                    q.add(new int[]{r,c});
                }
            }
            step++;
        }
        return -1;
    }
}