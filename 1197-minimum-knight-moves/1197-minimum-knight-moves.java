class Solution {
    public int minKnightMoves(int x, int y) {
        
        int[][] dir = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
        
        Set<String> set = new HashSet<>();
        LinkedList<int[]> q = new LinkedList<>();
        x = Math.abs(x); y = Math.abs(y);
        
        set.add(0+","+0);
        q.add(new int[]{0, 0});
        int steps = 0;
        
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                
                int[] top = q.poll();
                int i = top[0], j = top[1];
                
                if(i == x && j == y) return steps;
                
                for(int[] d : dir){
                    int r = i + d[0];
                    int c = j + d[1];
                    
                    if(!set.contains(r+","+c) && r >= -1 && c >= -1){
                        q.add(new int[]{r, c});
                        set.add(r+","+c);
                    }
                }
            }
            steps++;
        }
        return steps;
    }
}