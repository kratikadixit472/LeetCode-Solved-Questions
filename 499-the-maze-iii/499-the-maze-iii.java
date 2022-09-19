class Solution {
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        
        int n = maze.length, m = maze[0].length;
        
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        String[] sdir = {"u", "d", "l", "r"};
        
        String[][] dpPath = new String[n][m];
        int[][] dis = new int[n][m];
        for(int[] d : dis) Arrays.fill(d, Integer.MAX_VALUE);
        for(String[] s : dpPath) Arrays.fill(s, "z");
        
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{ball[0], ball[1]});
        dis[ball[0]][ball[1]] = 0;
        dpPath[ball[0]][ball[1]] = "";
        
        while(!q.isEmpty()){
            
            int[] top = q.poll();
            int i = top[0],  j = top[1];
            
            for(int k = 0; k < 4; k++){
                int[] d = dir[k];
                int r = d[0] + i;
                int c = d[1] + j;
                
                String path = dpPath[i][j] + sdir[k];
                int dist = dis[i][j];
                
                while(r >= 0 && c >= 0 && r < n && c < m && maze[r][c] == 0){
                    
                    if(r == hole[0] && c == hole[1]) break;
                    
                    r = r + d[0];
                    c = c + d[1];
                    dist++;
                }
                
                if(r != hole[0] || c != hole[1]){
                    r -= d[0]; c -= d[1];
                }
                
                if(r == i && c == j) continue;
                
                if(dist <= dis[r][c]){
                    if(dist < dis[r][c]){
                        dis[r][c] = dist;
                        dpPath[r][c] = path;
                    }
                    else if(path.compareTo(dpPath[r][c]) < 0){
                        dpPath[r][c] = path;
                    }
                    q.add(new int[] {r, c});
                }
            }
        }
        
        return dpPath[hole[0]][hole[1]].equals("z") ? "impossible" : dpPath[hole[0]][hole[1]];
    }
}