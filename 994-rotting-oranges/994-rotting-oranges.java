class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        int fresh = 0;
        LinkedList<int[]> queue = new LinkedList<>();
        int[][] dir = {{1, 0},{0, 1}, {0, -1}, {-1,0}};
        int n = grid.length, m = grid[0].length;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0) return 0;
        
        int count = 0;
        while(!queue.isEmpty() && fresh > 0){
            count++;
            int size = queue.size();
            while(size-- > 0){
                int[] pt = queue.poll();
                
                for(int[] d : dir){
                    int x = pt[0] + d[0];
                    int y = pt[1] + d[1];
                    
                    if(x < 0 || y < 0 || x >= n || y >= m || grid[x][y] == 2 || grid[x][y] == 0) continue;
                    grid[x][y] = 2;
                    queue.add(new int[]{x, y});
                    fresh--;
                }
            }
        }
        return (fresh==0) ? count : -1;
    }
}