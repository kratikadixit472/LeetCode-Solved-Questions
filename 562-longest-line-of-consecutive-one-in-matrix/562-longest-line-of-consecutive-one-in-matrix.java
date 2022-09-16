class Solution {
    
    public int longestLine(int[][] mat) {      
        int n = mat.length, m = mat[0].length;
        int max = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 1){
                    int horz = 0, vert = 0, diag = 0, anti = 0;
                    if(i == 0 || mat[i-1][j] == 0){
                        int row = i;
                        while(row < n && mat[row][j] == 1){
                            row++;
                            horz++;
                        }
                        max = Math.max(max, horz);
                    }
                    if(j == 0 || mat[i][j-1] == 0){
                        int col = j;
                        while(col < m && mat[i][col] == 1){
                            col++;
                            vert++;
                        }
                        max = Math.max(max, vert);
                    }
                    if(i == 0 || j == 0 || mat[i-1][j-1] == 0){
                        int row = i, col = j;
                        while(row < n && col < m && mat[row][col] == 1){
                            row++;col++;
                            diag++;
                        }
                        max = Math.max(max, diag);
                    }
                    if(i == 0 || j == m-1 || mat[i-1][j+1] == 0){
                        int row = i, col = j;
                        while(row < n && col >= 0 && mat[row][col] == 1){
                            row++; col--;
                            anti++;
                        }
                        max = Math.max(max, anti);
                    }
                }
            }
        }
        return max;
    }
}