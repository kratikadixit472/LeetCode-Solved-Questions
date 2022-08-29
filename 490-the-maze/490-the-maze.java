class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] dest) {
        
        int n = maze.length, m = maze[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        int[][] dir = {{-1,0}, {0,-1}, {0,1}, {1,0}};
        boolean[][] vis = new boolean[n][m];
        
        q.add(start);
        
        while(!q.isEmpty()){
            
            int[] top = q.poll();
            
            if(top[0] == dest[0] && top[1] == dest[1]) return true;
            
            for(int[] d : dir){
                int r = top[0] + d[0];
                int c = top[1] + d[1];
                
                while(r >= 0 && c >= 0 && r < n && c < m && maze[r][c] == 0){
                    
                    r += d[0]; c += d[1];
            
                }
                if(!vis[r-d[0]][c-d[1]]){
                    q.add(new int[]{r-d[0], c-d[1]});
                    vis[r-d[0]][c-d[1]] = true;
                }
            }
        }
        return false;
    }
}