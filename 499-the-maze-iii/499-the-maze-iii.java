class Solution {
    class Pair{
        
        int r, c;
        
        public Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int n = maze.length, m = maze[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        int[][] dir = {{-1,0}, {0,-1}, {0,1}, {1,0}};
        String[] dirs = {"u", "l", "r", "d"};
        
        int[][] dis = new int[n][m];
        String[][] pathdp = new String[n][m];
        
        for (String[] d: pathdp) {
            Arrays.fill(d, "z");
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++){
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }
        
        q.add(new int[] {ball[0], ball[1]});
        dis[ball[0]][ball[1]] = 0;
        pathdp[ball[0]][ball[1]] = "";
        
        while(!q.isEmpty()){
            
            int[] curr = q.poll();
            
            int i = curr[0], j = curr[1];
            
            for(int k = 0; k < 4; k++) {
                int[] d = dir[k];
                String path = pathdp[i][j] ;
                
                int r = i + d[0];
                int c = j + d[1];

                int cnt = 0;
                
                int dist = dis[i][j];
                path += dirs[k];
                
                while(r >= 0 && c >= 0 && r < n && c < m && maze[r][c] == 0) {

                    if(r == hole[0] && c == hole[1]) {
                        break;
                    }
                    
                    r += d[0]; 
                    c += d[1];
                    dist++;
                }
                
                if(r != hole[0] || c != hole[1]){
                    r -= d[0];
                    c -= d[1];
                }
                
                if(r == i && c == j) {
                    continue;
                }
                
                if(dis[r][c] >= dist){
                    
                   if(dis[r][c] > dist){
                       dis[r][c] = dist;
                       pathdp[r][c] = path;
                   }
                   else if(path.compareTo(pathdp[r][c]) < 0){
                        pathdp[r][c] = path;
                   }
                   q.add(new int[] {r, c});
                }
                
            }
        }
        return pathdp[hole[0]][hole[1]].equals("z") ? "impossible" : pathdp[hole[0]][hole[1]];
    }
}