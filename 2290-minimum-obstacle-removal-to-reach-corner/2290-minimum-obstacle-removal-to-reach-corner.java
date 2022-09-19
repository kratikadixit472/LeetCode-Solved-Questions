class Solution {
    public int minimumObstacles(int[][] grid) {
        
         int n = grid.length, m = grid[0].length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int[][] vis = new int[n][m];
        
        for(int[] v : vis) Arrays.fill(v, Integer.MAX_VALUE);
        
        vis[0][0] = grid[0][0];
        q.add(new int[]{0, 0, 0});
        
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                int[] top = q.poll();
                int i = top[0], j = top[1], k = top[2];

                if(i == n-1 && j == m-1) return k;
                for(int[] d : dir){
                    int r = i + d[0];
                    int c = j + d[1];

                    if(r >= 0 && c >= 0 && r < n && c < m){
                        int newk = k + grid[r][c];
                        if(vis[r][c] > newk){
                            vis[r][c] = newk;
                            q.add(new int[]{r, c, newk});
                        }
                    }
                }
            }
        }
        return vis[n-1][m-1];
    }
}