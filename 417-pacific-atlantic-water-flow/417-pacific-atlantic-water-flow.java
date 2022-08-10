class Solution {
    
    List<List<Integer>> ans;
    boolean[][] pacific, atlantic;   
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        ans = new ArrayList<>();
        int n = heights.length, m = heights[0].length;
        
        pacific = new boolean[n][m];
        atlantic = new boolean[n][m];
        
        for(int i = 0; i< m; i++){
            DFS(0, i, pacific, n, m, heights, heights[0][i]);
            
            DFS(n-1, i, atlantic, n, m, heights, heights[n-1][i]);
        }
        
        for(int i = 0 ; i < n; i++){
            DFS(i, 0, pacific, n, m, heights, heights[i][0]);
            
            DFS(i, m-1, atlantic, n, m, heights, heights[i][m-1]);
        }
        
        /*for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> al = new ArrayList<>();
                    al.add(i ); al.add(j);
                    ans.add(al);
                }
            }
        }*/
        
        return ans;
    }
    
    private void DFS(int i, int j, boolean[][] vis, int n, int m, int[][] heights, int prev){
        
        if(vis[i][j]) return;
        
        vis[i][j] = true;
        
        if(pacific[i][j] && atlantic[i][j]){
            List<Integer> al = new ArrayList<>();
            al.add(i ); al.add(j);
            ans.add(al);
        }
        
        if(i+1 < n && heights[i+1][j] >= heights[i][j]) DFS(i+1, j, vis, n, m, heights, heights[i][j]);
        if(j+1 < m && heights[i][j+1] >= heights[i][j]) DFS(i, j+1, vis, n, m, heights, heights[i][j]);
        if(i-1 >= 0 && heights[i-1][j] >= heights[i][j]) DFS(i-1, j, vis, n, m, heights, heights[i][j]);
        if(j-1 >= 0 && heights[i][j-1] >= heights[i][j]) DFS(i, j-1, vis, n, m, heights, heights[i][j]);
    }
}