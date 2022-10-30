class Solution {
    public int shortestPath(int[][] grid, int k) {
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        
        int n = grid.length, m = grid[0].length;
        int[][] steps = new int[n][m];
        for(int[] step : steps) Arrays.fill(step, Integer.MAX_VALUE);
        
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0, 0});
        steps[0][0] = 0;
        
        while(!q.isEmpty()){
            
            int[] top = q.poll();
            int i = top[0], j = top[1], dis = top[3], currk = top[2];
            
            if(i == n-1 && j == m-1) return dis;
            if(currk > k) continue;
            
            for(int[] d : dir){
                int r = i + d[0];
                int c = j + d[1];
                
                if(r >= 0 && c >= 0 && r < n && c < m){
                    int newk = grid[r][c] + currk;
                    if(newk <= k && newk < steps[r][c]){
                        steps[r][c] = newk;
                        q.add(new int[]{r, c, newk, dis + 1});
                    }
                }
            }
        }
        return -1;
    }
}