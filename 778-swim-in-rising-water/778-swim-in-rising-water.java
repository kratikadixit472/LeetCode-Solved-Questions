class Solution {
    public int swimInWater(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        int minTime = Integer.MIN_VALUE;
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] vis = new boolean[n][m];
        
        pq.add(new int[]{0, 0, grid[0][0]});
        vis[0][0] = true;
        
        while(!pq.isEmpty()){
            
            int[] top = pq.poll();
            int i = top[0], j = top[1], time = top[2];
            
            minTime = Math.max(minTime, time);
            if(i == n-1 && j == m-1) return minTime;
            
            for(int[] d : dir){
                int r = i + d[0];
                int c = j + d[1];
                
                if(r >= 0 && c >= 0 && r < n && c < m && !vis[r][c]){
                    vis[r][c] = true;
                    pq.add(new int[]{r, c, grid[r][c]});
                }
            }
        }
        return -1;
    }
}