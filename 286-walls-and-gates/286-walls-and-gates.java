class Solution {
    public void wallsAndGates(int[][] mat) {
        
        Queue<int[]> q = new LinkedList<>();
        int[][] dir = {{-1,0}, {0, -1}, {1,0}, {0,1}};
        boolean[][] vis = new boolean[mat.length][mat[0].length];
        
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i, j});
                    vis[i][j] = true;
                }
            }
        }
        
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                int[] rvtx = q.poll();
                
                for(int d = 0; d < 4; d++){
                    int r = rvtx[0] + dir[d][0];
                    int c = rvtx[1] + dir[d][1];
                    
                    if(r < 0 || c < 0 || r >= mat.length || c >= mat[0].length || mat[r][c] == -1 || vis[r][c] == true) continue;
                    vis[r][c] = true;
                    mat[r][c] = (mat[rvtx[0]][rvtx[1]]) + 1;
                    q.add(new int[] {r, c});
                }
            }
        }
        //return mat;
    }
}