class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        if(grid[0][0] != 0 || grid[grid.length-1][grid[0].length-1] != 0) return -1;
        
        LinkedList<int[]> q = new LinkedList<>();
        
        int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {1, -1}, {-1, 1}, {1, 1}, {-1, -1}};
        
        q.add(new int[]{0, 0});
        grid[0][0] = 1;
        
        int level = 0;
        
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                
                int[] peek = q.poll();
                
                if(peek[0] == grid.length-1 && peek[1] == grid[0].length-1) return level + 1;
                
                for(int[] d : dir){
                    int r = peek[0] + d[0];
                    int c = peek[1] + d[1];
                    
                    if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 0){
                        q.add(new int[] {r, c});
                        grid[r][c] = 1;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}