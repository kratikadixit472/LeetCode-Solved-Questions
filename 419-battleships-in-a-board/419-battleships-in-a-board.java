class Solution {
    
    int row, col ;
    int n, m;
    
    public int countBattleships(char[][] board) {
        
        n = board.length; m = board[0].length;
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int ans = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'X'){
                    DFS(i, j, board, dir);
                    if(row == i || col == j){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    
    private void DFS(int i, int j, char[][] board, int[][] dir){
        
        row = i; col = j;
        board[i][j] = '.';
        
        for(int[] d : dir){
            int r = i + d[0];
            int c = j + d[1];
            
            if(r >= 0 && c >= 0 && r < n && c < m && board[r][c] == 'X'){
                DFS(r, c, board, dir);
            }
        }
    }
}