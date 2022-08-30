class Solution {
    
    int lastr = -1, lastc = -1;
    int n, m;
    
    public int[][] findFarmland(int[][] land) {
        
        n = land.length; m = land[0].length;
        int[][] dir = {{-1,0},{0, -1}, {1, 0}, {0,1}};
        
        List<int[]> al = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            
            for(int j = 0; j < m; j++){
                if(land[i][j] == 1 && (i == 0 || land[i-1][j] == 0) && (j == 0 || land[i][j-1] == 0)){
                    
                    int c = j;
                    while(c < m && land[i][c] == 1) {
                        c++;
                    }
                    c--;
                    
                    int r = i;
                    while(r < n && land[r][c] == 1) {
                        r++;
                    }
                    r--;
                    
                    al.add(new int[] {i, j, r, c});
                }
            }
        }
        
        int[][] ans = new int[al.size()][4];
        int idx = 0;
        
        for(int[] arr : al){
            ans[idx] = arr;
            idx++;
        }
        return ans;
    }
    
//     private void DFS(int r, int c, int[][] land, int[][] dir){
//         lastr = r; lastc = c;
        
//         land[r][c] = 0;
        
//         for(int[] d : dir){
//             int x = r + d[0];
//             int y = c + d[1];
//             if(x >= 0 && y >= 0 && x < n && y < m && land[x][y] == 1){
//                 DFS(x, y, land, dir);
//             }
//         }
//     }
}