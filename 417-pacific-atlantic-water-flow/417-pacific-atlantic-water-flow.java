class Solution {
    
    int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        int n = heights.length, m = heights[0].length;
        
        List<List<Integer>> ans = new ArrayList<>();
        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();
        
        boolean[][] pacificMat = new boolean[n][m];
        boolean[][] atlanticMat = new boolean[n][m];
        
        for(int i = 0; i < m; i++){
            dfs(0, i, heights, n, m, pacificMat);
            dfs(n-1, i, heights, n, m, atlanticMat);
        }
        for(int i = 0; i < n; i++){
            dfs(i, 0, heights, n, m, pacificMat);
            dfs(i, m-1, heights, n, m, atlanticMat);
        }
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m; j++){
                if(atlanticMat[i][j] == true && pacificMat[i][j] == true){
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }
    
    private boolean[][] dfs(int r, int c, int[][] heights, int n, int m, boolean[][] mark){
    
        mark[r][c] = true;

        for(int[] d : dir){
            int x = r + d[0];
            int y = c + d[1];

            if(x >= 0 && y >= 0 && x < n && y < m && !mark[x][y]){

                if(heights[r][c] <= heights[x][y]){
                    dfs(x, y, heights, n, m, mark);
                }

            }
        }
        
        return mark;
    }
}