class Solution {
    
    private boolean isValid(int r, int c, int n, int m){
        return (r >= 0 && c >= 0 && r < n && c < m);
    }
    
    public boolean placeWordInCrossword(char[][] board, String word) {
        
        int n = board.length, m = board[0].length;
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                
                if(board[i][j] == ' ' || board[i][j] == word.charAt(0)){
                    
                    for(int[] d : dir){
                        
                        int r = i, c = j;
                        
                        if(isValid(r - d[0], c - d[1], n, m) && board[r - d[0]][c - d[1]] != '#') continue;
                        int idx = 0;
                        
                        while(idx < word.length() && isValid(r, c, n, m)){
                            if(board[r][c] == '#' || (board[r][c] != ' ' && board[r][c] != word.charAt(idx))) break;
                            
                            idx++;
                            r += d[0];
                            c += d[1];
                        }
                        
                        if(idx == word.length() && (!isValid(r, c, n, m) || board[r][c] == '#')) return true;
                    }
                }
            }
        }
        return false;
    }
}