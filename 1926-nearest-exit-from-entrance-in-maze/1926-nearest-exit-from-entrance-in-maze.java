class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{entrance[0], entrance[1]});
        maze[entrance[0]][entrance[1]] = '+';
        
        int n = maze.length, m = maze[0].length;
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int near = 0;
        
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                int[] curr = q.poll();
                
                int i = curr[0], j = curr[1];
                
                for(int[] d : dir){
                    int r = i + d[0];
                    int c = j + d[1];
                    
                    if(r < 0 || c < 0 || r >= n || c >= m || maze[r][c] == '+' ) continue;
                    
                    if((r == 0 || c == 0 || r == n-1 || c == m-1)) return near + 1;
                    
                    if(r >= 0 && c >= 0 && r < n && c < m && maze[r][c] == '.'){          
                        maze[r][c] = '+';
                        q.add(new int[]{r, c});
                    }
                    
                }
            }
            near++;
        }
        return -1;
    }
}