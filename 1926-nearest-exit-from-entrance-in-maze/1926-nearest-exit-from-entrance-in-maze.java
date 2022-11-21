class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        
        int exit = 0, n = maze.length, m = maze[0].length;
        LinkedList<int[]> q = new LinkedList<>();
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        boolean[][] vis = new boolean[n][m];
          
        q.add(new int[]{entrance[0], entrance[1]});
        vis[entrance[0]][entrance[1]] = true;
        
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                
                int[] curr = q.poll();
                
                for(int[] d : dir){
                    int r = curr[0] + d[0];
                    int c = curr[1] + d[1];
                    
                    if(r >= 0 && c >= 0 && r < n && c < m && maze[r][c] == '.' && !vis[r][c]){
                        if(r == 0 || r == n-1 || c == 0 || c == m-1) return exit + 1;
                        q.add(new int[]{r, c});
                        vis[r][c] = true;
                    }
                }
            }
            exit++;
        }
        return -1;
    }
}