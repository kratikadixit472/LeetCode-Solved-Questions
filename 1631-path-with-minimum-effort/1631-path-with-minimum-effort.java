class Solution {
    
    int n, m;
    int[][] dir = {{-1,0}, {0,-1}, {0,1}, {1,0}};
    
    public int minimumEffortPath(int[][] heights) {
        
        n = heights.length; m = heights[0].length;
        int[][] efforts = new int[n][m];
        for(int[] e : efforts) Arrays.fill(e, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.add(new int[3]);
        efforts[0][0] = 0;
        
        while(!q.isEmpty())
        {
            int[] top = q.poll();
            
            int effort = top[0], i = top[1], j = top[2];
            if(i == n-1 && j == m-1){
                return effort;
            }

            for(int[] d : dir){
                int r = i + d[0];
                int c = j + d[1];

                if(r >= 0 && c >= 0 && r < n && c < m && heights[r][c] != 0){

                    int nextEffort = Math.max(effort, Math.abs(heights[r][c] - heights[i][j]));
                    if(efforts[r][c] > nextEffort){
                        efforts[r][c] = nextEffort;
                        q.add(new int[]{nextEffort, r, c});
                    }
                }
            }
        }
        
        return 0;
    }
}