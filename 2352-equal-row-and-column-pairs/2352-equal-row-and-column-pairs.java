class Solution {
    public int equalPairs(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        
        int[][] inv = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                inv[i][j] = grid[j][i];
            }
        }
        
        int ans = 0;
        
        int jj = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <n; j++){
                int k = 0;
                for(k = 0; k <m ; k++){
                    if(inv[i][k] != grid[j][k]) break;
                    
                }
                if(k == m) ans++;
            }
        }
        
         /*for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(inv[i][j] +" ");
            }
            System.out.println();
        }*/
        
        //if(n == m && ans == n) return 2 * ans;
        return ans;
    }
}