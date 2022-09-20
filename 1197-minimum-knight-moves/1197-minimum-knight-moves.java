class Solution {
    public int minKnightMoves(int x, int y) {
        
        int[][] dir = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
        
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        boolean[][] visited = new boolean[607][607];
        visited[0][0] = true;
        
        int distance = 0;
        
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                int[] top = q.poll();
                
                int i = top[0], j = top[1];
                
                if(i == x && j == y) return distance;
                
                for(int[] d: dir){
                    int r = i + d[0];
                    int c = j + d[1];
                    
                    
                    if (!visited[r + 302][c + 302]) {
                        visited[r + 302][c + 302] = true;
                        q.add(new int[]{r, c});
                    }
                    
                }
            }
            distance++;
        }
        return distance;
    }
}