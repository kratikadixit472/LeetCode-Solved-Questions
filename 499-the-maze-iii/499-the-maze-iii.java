class Solution {
    
    class Pair{
        int x, y, dis;
        String s;
        public Pair(int x, int y, String s, int dis){
            this.x = x;
            this.y = y;
            this.dis = dis;
            this.s = s;
        }
    }
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        
        int n = maze.length, m = maze[0].length;
        
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        String[] sdir = {"u", "d", "l", "r"};
        
        boolean[][] vis = new boolean[n][m];
        
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) ->{
            if (a.dis == b.dis) { 
                return (a.s).compareTo(b.s);
            } else {
                return a.dis - b.dis;
            }
        });
        
        q.add(new Pair(ball[0], ball[1], "", 0));
        // vis[ball[0]][ball[1]] = true;
        
        while(!q.isEmpty()){
            
            Pair top = q.poll();
            
            int i = top.x,  j = top.y, dist = top.dis;
            String path = top.s;
            
            if(i == hole[0] && j == hole[1]) return path;
            if(vis[i][j]) continue;
            
            
            vis[i][j] = true;
            for(int k = 0; k < 4; k++){
                int[] d = dir[k];
                int r = i + d[0];
                int c = j + d[1];
                
                int kk = 0;
                while(r >= 0 && c >= 0 && r < n && c < m && maze[r][c] == 0){
                    
                   if(r == hole[0] && c == hole[1]) break;
                    r = r + d[0];
                    c = c + d[1];
                    kk++;
                }
                
                if(r != hole[0] || c != hole[1]){
                    r -= d[0]; c -= d[1];
                    // kk--;
                }
                
                // if(r == i && c == j) continue;
                
                if(!vis[r][c]){
                    // vis[r][c] = true;
                    q.add(new Pair (r, c, path+sdir[k], dist+kk));
                }
            }
        }
        
        return "impossible";
    }
    
}