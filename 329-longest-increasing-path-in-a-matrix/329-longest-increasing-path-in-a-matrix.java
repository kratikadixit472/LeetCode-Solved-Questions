class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        
        int n = matrix.length, m = matrix[0].length;
        int[][] indegree = new int[n][m];
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                
                for(int[] d : dir){
                    int r = i + d[0];
                    int c = j + d[1];
                    
                    if(r >= 0 && c >= 0 && r < n && c < m && matrix[i][j] < matrix[r][c]){
                        indegree[r][c]++;
                    }
                }
            }
        }
        
        LinkedList<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(indegree[i][j] == 0){
                    q.add(new int[]{i, j});
                }
            }
        }
        
        int longestInc = 0;
        
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                
                int[] top = q.poll();
                int r = top[0], c = top[1];
                
                for(int[] d : dir){
                    int row = r + d[0];
                    int col = c + d[1];
                    
                    if(row >= 0 && col >= 0 && row < n && col < m && matrix[row][col] > matrix[r][c]){
                        if(--indegree[row][col] == 0) q.add(new int[]{row, col});
                    }
                }
            }
            longestInc++;
        }
        return longestInc;
    }
}