class Solution {
    public void solve(char[][] board) {
        
        int row = board.length, col = board[0].length;
        
        for(int i = 0; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(i == 0 || j == 0 || i == row-1 || j == col-1){
                    if(board[i][j] == 'O'){
                        boundaryDFS(board, i, j, row, col);
                    }
                }
            }
        }
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '*'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void boundaryDFS(char[][] board, int i, int j, int row, int col){
        
        if(i < 0 || j< 0 || i>= row || j >= col || board[i][j] == 'X') return;
        
        if(board[i][j] == 'O'){
        board[i][j] = '*';
        
        boundaryDFS(board, i+1, j, row, col);
        boundaryDFS(board, i-1, j, row, col);
        boundaryDFS(board, i, j-1, row, col);
        boundaryDFS(board, i, j+1, row, col);
        }
    }
}