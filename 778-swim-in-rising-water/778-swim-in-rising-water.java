class Solution {
    public int swimInWater(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{grid[0][0], 0, 0});
        int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        boolean[][] vis = new boolean[n][m];
        
        int ans = 0;
        while(!pq.isEmpty()){
            
            int[] top = pq.poll();
            int t = top[0], i = top[1], j = top[2];
            ans = Math.max(ans, grid[i][j]);
            
            if(i == n-1 && j == m-1) return ans;
            
            for(int[] d : dir){
                int r = i + d[0];
                int c = j + d[1];
                
                if(r >= 0 && c >= 0 && r < n &&  c < m && !vis[r][c]){
                    pq.add(new int[]{grid[r][c], r, c});
                    vis[r][c] = true;
                }
            }
        }
        return 0;
    }
}