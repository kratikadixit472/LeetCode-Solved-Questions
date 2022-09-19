class Solution {
    public int shortestPath(int[][] grid, int K) {
        
        int n = grid.length, m = grid[0].length;
        LinkedList<int[]> q = new LinkedList<>();
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int[][] vis = new int[n][m];
        
        for(int[] v : vis) Arrays.fill(v, Integer.MAX_VALUE);
        
        vis[0][0] = 0;
        q.add(new int[]{0, 0, 0, 0});
        
        while(!q.isEmpty()){
            
            int[] top = q.poll();
            int i = top[0], j = top[1], k = top[2], dis = top[3];
            
            // System.out.println(i+" "+ j +" "+ k +" "+ dis);
            if(i == n-1 && j == m-1) return dis;
            for(int[] d : dir){
                int r = i + d[0];
                int c = j + d[1];
                
                if(r >= 0 && c >= 0 && r < n && c < m){
                    int newk = k + grid[r][c];
                    if(newk <= K && vis[r][c] > newk){
                        vis[r][c] = newk;
                        q.add(new int[]{r, c, newk, dis+1});
                    }
                }
            }
        }
        return -1;
    }
}