class Solution {
    int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int uniquePathsIII(int[][] grid) {
        
        LinkedList<int[]> q = new LinkedList<>();
        int i = 0, j = 0, n = grid.length, m = grid[0].length;
        int start_r = 0, start_c = 0, remain = 0;

        for(i = 0; i < n; i++){
            for(j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    q.add(new int[]{i, j});
                    start_r = i; start_c = j;
                }
                if(grid[i][j] >= 0)remain++;
            }
        }
        
        return numberPath(start_r, start_c, n, m, grid, remain);
    }
    
    private int numberPath(int sr, int sc, int n, int m, int[][] grid, int remain){
        
        if(grid[sr][sc] == 2 && remain == 1){
            return 1;
        }

        int tmp = grid[sr][sc];
        grid[sr][sc] = -1;
        int cnt = 0;
        remain = remain - 1;

        for(int[] d : dir){
            int r = d[0] + sr;
            int c = d[1] + sc;

            if(r < 0 || c < 0 || r >= n || c >= m || grid[r][c] == -1)continue;
            cnt += numberPath(r, c, n, m, grid, remain);
        }
        grid[sr][sc] = tmp;
        return cnt;
    }
}