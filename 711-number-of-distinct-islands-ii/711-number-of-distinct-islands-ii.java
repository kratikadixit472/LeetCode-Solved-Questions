class Solution {
    public int numDistinctIslands2(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        Set<Map<Integer, Integer>> allDistinctIsland = new HashSet<>();
        int[][] dir = {{-1, 0}, {0,-1}, {0, 1} , {1, 0}};
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                
                if(grid[i][j] == 1){
                    
                    List<int[]> allAdjacent = new ArrayList<>();
                    DFS(i, j, n, m, grid, allAdjacent, dir);
                    
                    Map<Integer, Integer> getAllDistance = new HashMap<>();
                    
                    for(int k = 0; k < allAdjacent.size(); k++){
                        for(int l = k+1; l < allAdjacent.size(); l++){
                            
                            int[] a = allAdjacent.get(k);
                            int[] b = allAdjacent.get(l);
                            
                            int dist = (int)Math.pow(a[0] - b[0], 2) + (int)Math.pow(a[1] - b[1], 2);
                            
                            getAllDistance.put(dist, getAllDistance.getOrDefault(dist, 0) + 1);
                        }
                    }
                    allDistinctIsland.add(getAllDistance);
                }
            }
        }
        return allDistinctIsland.size();
    }
    
    private void DFS(int r, int c, int n, int m, int[][] grid, List<int[]> al, int[][] dir){
        
        al.add(new int[]{r, c});
        grid[r][c] = 0;
        
        for(int[] d : dir){
            int row = r + d[0];
            int col = c + d[1];
            
            if(row >= 0 && col >= 0 && row < n && col < m && grid[row][col] == 1){
                DFS(row, col, n, m, grid, al, dir);
            }
        }
    }
}