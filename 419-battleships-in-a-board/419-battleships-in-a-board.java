class Solution {
    
    int ii, jj;
    //int[][] dir;
    
    public int countBattleships(char[][] board) {
       
        int ans = 0;
        int n = board.length, m = board[0].length;
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        for(int i = 0; i< n; i++){
            for(int j = 0 ; j < m; j++){
                if(board[i][j] == 'X'){
                    DFS(i, j, n, m, board, dir);
                    //if(ii == i || jj == j) 
                    ans++;
                }
            }
        }
        return ans;
    }
    private void DFS(int i, int j, int n, int m, char[][] board, int[][] dir){
        
        ii = i; jj = j;
        board[i][j] = 'O';
        
        for(int d = 0; d < 4; d++){
            int r = i + dir[d][0];
            int c = j + dir[d][1];
            
            if(r >= 0 && c >= 0 && r < n && c < m && board[r][c] == 'X'){
                DFS(r, c, n, m, board, dir);
            }
        }
    }
}