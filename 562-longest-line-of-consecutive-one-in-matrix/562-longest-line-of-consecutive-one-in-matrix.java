class Solution {
    public int longestLine(int[][] mat) {
        
        int max = 0, n = mat.length, m = mat[0].length;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0) continue;

                else{
                    int cnt = 0;
                    if(i == 0 || mat[i-1][j] == 0){
                        int row = i, horz = 0;
                        while(row < n && mat[row][j] == 1){
                            row++;
                            horz++;
                        }
                        max = Math.max(max, horz);
                    }
                    if(j == 0 || mat[i][j-1] == 0){
                        int col = j, vert = 0;
                        while(col < m && mat[i][col] == 1){
                            col++;
                            vert++;
                        }
                        max = Math.max(max, vert);
                    }
                    if(i == 0 || j == 0 || mat[i-1][j-1] == 0){
                        int row = i, col = j, diag = 0;
                        while(row < n && col < m && mat[row][col] == 1){
                            row++;
                            col++;
                            diag++;
                        }
                        max = Math.max(max, diag);
                    }
                    if(i == 0 || j == m-1 || mat[i-1][j+1] == 0){
                        int row = i, col = j, adiag = 0;
                        while(row < n && col >= 0 && mat[row][col] == 1){
                            row++;
                            col--;
                            adiag++;
                        }
                        max = Math.max(max, adiag);
                    }
                    
                }
            }
        }
        return max;
    }
}