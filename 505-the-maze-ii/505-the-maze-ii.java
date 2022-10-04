class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        
        int n = maze.length, m = maze[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1], 0});
        int[][] dis = new int[n][m];
        
        for(int[] d : dis) Arrays.fill(d, Integer.MAX_VALUE);
        dis[start[0]][start[1]] = 0;
        
        
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        
        while(!q.isEmpty()){
            
            int[] top = q.poll();
            
            int i = top[0], j = top[1], dist = top[2];
            
            // if(dis[i][j] < dist) continue;  
            
            for(int[] d : dir){
                
                int row = i + d[0];
                int col = j + d[1];
                int cnt = 0;
                
                while(row >= 0 && col >= 0 && row < n && col < m && maze[row][col] == 0){
                    cnt++;
                    row += d[0];
                    col += d[1];
                }
                
                row -= d[0]; col -= d[1];
                
                if(dis[row][col] > cnt + dis[i][j]){
                    q.add(new int[]{row, col, cnt + dis[i][j]});
                    dis[row][col] = cnt + dis[i][j];
                }
                
            }
        }
        return dis[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : dis[dest[0]][dest[1]];
    }
}