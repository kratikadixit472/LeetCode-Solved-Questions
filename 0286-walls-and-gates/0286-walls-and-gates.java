class Solution {
    public void wallsAndGates(int[][] rooms) {
        
        int n = rooms.length, m = rooms[0].length;
        LinkedList<int[]> q = new LinkedList<>();
        
        for(int i =0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                if(rooms[i][j] == 0){
                    q.add(new int[]{i, j});
                }
            }
        }
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while(!q.isEmpty()){
            int[] top = q.poll();
            
            for(int[] d : dir){
                int r = d[0] + top[0];
                int c = d[1] + top[1];
                
                if(r >= 0 && c >= 0 && r < n&& c < m && rooms[r][c] != -1){
                    if(rooms[r][c] > rooms[top[0]][top[1]]){
                        q.add(new int[]{r, c});
                        rooms[r][c] = rooms[top[0]][top[1]] + 1;
                    }
                }
            }
        }
    }
}