class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int n = mat.length, m = mat[0].length;
        
        LinkedList<int[]> q = new LinkedList<>();
        
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        boolean[][] vis = new boolean[n][m];
        
        for(int i =0 ; i< n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i, j});
                    vis[i][j] = true;
                }
            }
        }
        
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                int[] curr = q.poll();
                
                int i = curr[0], j = curr[1];
                
                for(int[] d: dir){
                    int r = i + d[0];
                    int c = j + d[1];
                    
                    if(r >= 0 && c >= 0 && r < n && c < m && !vis[r][c] && mat[r][c] != 0){
                        mat[r][c] += mat[i][j];
                        vis[r][c] = true;
                        q.add(new int[]{r, c});
                    }
                }
            }
        }
        
        return mat;
    }
}