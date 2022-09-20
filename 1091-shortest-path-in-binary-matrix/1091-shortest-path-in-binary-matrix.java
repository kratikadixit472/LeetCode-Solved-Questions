class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        LinkedList<int[]> q = new LinkedList<>();
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
        
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1) return -1;
        
        q.add(new int[]{0, 0});
        grid[0][0] = 1;
        
        int distance = 0;
        
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                
                int[] top = q.poll();
                
                int i = top[0], j = top[1];
                
                if(i == n-1 && j == m-1) return distance + 1;
                for(int[] d : dir){
                    int r = i + d[0];
                    int c = j + d[1];
                    
                    if(r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 0){
                        grid[r][c] = 1;
                        q.add(new int[]{r, c});
                    }
                }
            }
            distance++;
        }
        return -1;
    }
}