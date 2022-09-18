class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        
        int n = matrix.length, m = matrix[0].length;
        
        int[][] indegree = new int[n][m];
        int[][] vis = {{-1,0},{0,-1},{1,0},{0,1}};
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int[] d : vis){
                    int r = d[0] + i;
                    int c = d[1] + j;
                    
                    if(r >= 0 && c >= 0 && r < n && c < m && matrix[i][j] > matrix[r][c]){
                        indegree[i][j]++;
                    }
                }
            }
        }
        
        LinkedList<int[]> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(indegree[i][j] == 0) q.add(new int[]{i, j});
            }
        }
        int longest = 0;
        
        while(!q.isEmpty()){
            int sz = q.size();
                while(sz-- > 0){
                int[] top = q.poll();
                for(int[] d : vis){
                    int r = d[0] + top[0];
                    int c = d[1] + top[1];

                    if(r >= 0 && c >= 0 && r < n && c < m && matrix[top[0]][top[1]] < matrix[r][c] && --indegree[r][c] == 0){
                        q.add(new int[]{r, c});
                    }
                }
            }
            longest++;
        }
        return longest;
    }
}