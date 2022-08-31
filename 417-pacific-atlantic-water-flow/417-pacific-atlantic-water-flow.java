class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        int n = heights.length, m = heights[0].length;
        
        List<List<Integer>> ans = new ArrayList<>();
        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();
        
        for(int i = 0; i < m; i++){
            pacificQueue.add(new int[]{0, i});
            atlanticQueue.add(new int[]{n-1, i});
        }
        for(int i = 0; i < n; i++){
            pacificQueue.add(new int[]{i, 0});
            atlanticQueue.add(new int[]{i, m-1});
        }
        
        boolean[][] pacificMat = bfs(pacificQueue, heights);
        boolean[][] atlanticMat = bfs(atlanticQueue, heights);
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m; j++){
                if(atlanticMat[i][j] == true && pacificMat[i][j] == true){
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }
    
    private boolean[][] bfs(Queue<int[]> q, int[][] heights){
        
        int n = heights.length, m = heights[0].length;
        
        boolean[][] mark = new boolean[n][m];
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        
        while(!q.isEmpty()){
            
            int[] top = q.poll();
            int r = top[0], c = top[1];
            
            mark[r][c] = true;
            
            for(int[] d : dir){
                int x = r + d[0];
                int y = c + d[1];
                
                if(x >= 0 && y >= 0 && x < n && y < m && !mark[x][y]){
                    
                    if(heights[r][c] <= heights[x][y]){
                        q.add(new int[]{x, y});
                    }
                    
                }
            }
        }
        return mark;
    }
}