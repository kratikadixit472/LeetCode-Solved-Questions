class Solution {
    int n, m;
    int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    String[] sdir = {"u", "l", "d", "r"};
    
    public int numDistinctIslands(int[][] board) {
        
        n = board.length; m = board[0].length;
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 1){
                    StringBuilder sb = new StringBuilder();
                    sb.append("s");
                    DFS(i, j, board, sb);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }
    
    private void DFS(int i, int j, int[][] board, StringBuilder sb){
        
        board[i][j] = 0;
        
        for(int k = 0; k < 4; k++){
            int[] d = dir[k];
            int r = i + d[0];
            int c = j + d[1];
            
            if(r >= 0 && c >= 0 && r < n && c < m && board[r][c] == 1){
                sb.append(sdir[k]);
                DFS(r, c, board, sb);
            }
        }
        sb.append("b");
    }
}