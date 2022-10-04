class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] dest) {
        int n = maze.length, m = maze[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1]});
        boolean[][] vis = new boolean[n][m];
        
        // for(int[] d : dis) Arrays.fill(d, Integer.MAX_VALUE);
        vis[start[0]][start[1]] = true;
        
        
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        
        while(!q.isEmpty()){
            
            int[] top = q.poll();
            
            int i = top[0], j = top[1];
            
            if(i == dest[0] && j == dest[1]) return true;  
            
            for(int[] d : dir){
                
                int row = i + d[0];
                int col = j + d[1];
                
                while(row >= 0 && col >= 0 && row < n && col < m && maze[row][col] == 0){
                    row += d[0];
                    col += d[1];
                }
                
                row -= d[0]; col -= d[1];
                
                if(vis[row][col]) continue;
                
                q.add(new int[]{row, col});
                vis[row][col] = true;
                 
            }
        }
        return false;
    }
}