class Solution {
    
    int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    int n, m;
    
    public boolean exist(char[][] board, String word) {
        
        n = board.length; m = board[0].length;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(word.charAt(0) == board[i][j]){
                    if(doesExist(i, j, board, 0, word)) return true;
                } 
            }
        }
        return false;
    }
    
    private boolean doesExist(int i, int j, char[][] board, int idx, String word){
        
        if(idx == word.length()-1 && board[i][j] == word.charAt(idx)) return true;
        if(idx >= word.length()) return false;
        
        boolean res = false;
        
        char tmp = board[i][j];
        board[i][j] = '.';
        
        for(int[] d : dir){
            int r = i + d[0];
            int c = j + d[1];
            
            if(r >= 0 && c >= 0 && r < n && c < m && idx+1 < word.length() && board[r][c] == word.charAt(idx+1)){
                res = res || doesExist(r, c, board, idx+1, word);
            }
        }
        board[i][j] = tmp;
        
        return res;
    }
}