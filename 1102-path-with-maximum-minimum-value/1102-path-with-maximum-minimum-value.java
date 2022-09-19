class Solution {
    public int maximumMinimumPath(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        int[][] dir = {{-1,0}, {0,-1}, {0,1}, {1,0}};
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        q.add(new int[]{grid[0][0], 0, 0});
        boolean[][] vis = new boolean[n][m];
        vis[0][0] = true;
        
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty())
        {
            int[] top = q.poll();
            
            int curr = top[0], i = top[1], j = top[2];
            min = Math.min(min, curr);
            if(i == n-1 && j == m-1){
                return min;
            }

            for(int[] d : dir){
                int r = i + d[0];
                int c = j + d[1];

                if(r >= 0 && c >= 0 && r < n && c < m && !vis[r][c]){

                    vis[r][c] = true;
                    q.add(new int[]{grid[r][c], r, c});
                    
                }
            }
        }
        
        return 0;
    }
}