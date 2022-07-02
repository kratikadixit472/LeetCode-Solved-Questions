class Solution {
   
    int shortPath = (int)(1e9);
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length, m = grid[0].length;

        if(grid[0][0] == 1 || grid[n-1][m-1] == 1){
            return -1;
        }
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1}, {-1,-1}, {-1,1}, {1,-1}};

        int level = 1;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        grid[0][0] = 1;
        
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                int[] rvtx = q.poll();
                
                if(rvtx[0] == n-1 && rvtx[1] == m-1) return level;
                
                for(int[] dir : dirs){
                    int x = rvtx[0] + dir[0];
                    int y = rvtx[1] + dir[1];
                    
                    if(x >= 0 && y >= 0&& x < grid.length && y < grid.length && grid[x][y] == 0){
                        
                        grid[x][y] = 1;
                        q.add(new int[]{x, y});
                    }
                }
            }
            level++;
        }
        
        return -1;
    }
}