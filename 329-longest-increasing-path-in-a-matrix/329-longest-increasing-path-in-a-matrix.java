class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        
        int n = matrix.length, m = matrix[0].length;
        
        int[][] indegree = new int[n][m];
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m ; j++){
                // if(i-1 >= 0 && matrix[i-1][j] < matrix[i][j]) indegree[i][j]++;
                // if(j-1 >= 0 && matrix[i][j-1] < matrix[i][j]) indegree[i][j]++;
                // if(i+1 <= n-1 && matrix[i+1][j] < matrix[i][j]) indegree[i][j]++;
                // if(j+1 <= m-1 && matrix[i][j+1] < matrix[i][j]) indegree[i][j]++;
                
                for(int []d : dir){
                    int r = i + d[0];
                    int c = j + d[1];
                    
                    if(r >= 0 && c >= 0 && r < n && c < m && matrix[r][c] < matrix[i][j] ) indegree[i][j]++;
                }
            }
        }
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m ; j++){
                System.out.print(indegree[i][j] +" ");
            }
            System.out.println();
        }
        
        LinkedList<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(indegree[i][j] == 0) q.add(new int[]{i, j});
            }
        }
        
        int level = 0;
        
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                int[] curr = q.poll();
                
                int i = curr[0], j = curr[1];
                
                for(int[] d : dir){
                    int r = i + d[0];
                    int c = j + d[1];
                    
                    if(r >= 0 && c >= 0 && r < n && c < m && matrix[r][c] > matrix[i][j] && --indegree[r][c] == 0) q.add(new int[]{ r, c});
                }
            }
            level++;
        }
        return level;
    }
}