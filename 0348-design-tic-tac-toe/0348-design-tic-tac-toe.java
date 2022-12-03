class TicTacToe {

    int[] rows; 
    int[] cols;
    int diagonal = 0, antiDiagonal = 0, n;
    
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        this.n = n;
    }
    
    public int move(int row, int col, int player) {
        int currPlayer = (player == 1) ? 1 : -1;
        cols[col] += currPlayer;
        rows[row] += currPlayer;
        
        if(row == col){
            diagonal += currPlayer;
        }
        if(col == n - row - 1){
            antiDiagonal += currPlayer;
        }
        if(Math.abs(diagonal) == n || Math.abs(antiDiagonal) == n || Math.abs(rows[row]) == n || Math.abs(cols[col]) == n ){
            return player;
        }
        return 0;
    }
    
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */