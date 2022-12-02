class TicTacToe {

    int[][] board;
    int n;
    
    public TicTacToe(int n) {
        board = new int[n][n];
        this.n = n;
    }
    
    public int move(int row, int col, int player) {
        board[row][col] = player;
        if(checkRow(row, player) || checkCol(col, player) ||
          (row == col && checkDiag(player)) ||
          (col == n - row - 1) && checkAntiDiag(player)){
            return player;
        }
        return 0;
    }
    private boolean checkRow(int row, int player){
        for(int i = 0; i < n; i++){
            if(board[row][i] != player) return false;
        }
        return true;
    }
    private boolean checkCol(int col, int player){
        for(int i = 0; i < n; i++){
            if(board[i][col] != player) return false;
        }
        return true;
    }
    private boolean checkDiag(int player){
        for(int i = 0; i < n; i++){
            if(board[i][i] != player) return false;
        }
        return true;
    }
    private boolean checkAntiDiag(int player){
        for(int i = 0; i < n; i++){
            if(board[i][n-i-1] != player) return false;
        }
        return true;
    }
    
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */