class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        
        int n = maze.length, m = maze[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        int[][] dir = {{-1,0}, {0,-1}, {0,1}, {1,0}};
        int[][] dis = new int[n][m];
        
        for(int i = 0; i < n; i++){
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }
        
        q.add(start);
        int distance = 0;
        dis[start[0]][start[1]] = 0;
        
        while(!q.isEmpty()){
            
            int[] top = q.poll();
            int i = top[0], j = top[1];

            // if(i == dest[0] && j == dest[1]) return dis[dest[0]][dest[1]];

            for(int[] d : dir) {
                int r = i + d[0];
                int c = j + d[1];

                int cnt = 0;

                while(r >= 0 && c >= 0 && r < n && c < m && maze[r][c] == 0) {

                    r += d[0]; 
                    c += d[1];
                    cnt++;

                }
                if(dis[i][j] + cnt < dis[r-d[0]][c-d[1]]) {
                    q.add(new int[]{r-d[0], c-d[1]});
                    dis[r-d[0]][c-d[1]] = dis[i][j] + cnt;
                }
            }
            
        }
        return dis[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : dis[dest[0]][dest[1]];
    }
}