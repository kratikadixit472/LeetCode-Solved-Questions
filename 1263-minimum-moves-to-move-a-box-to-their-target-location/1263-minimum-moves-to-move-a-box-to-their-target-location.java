class Solution {
    
    int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    public int minPushBox(char[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        
        int[] box = null;
        int[] target = null;
        int[] player = null;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                
                if(grid[i][j] == 'B') box = new int[]{i, j};
                if(grid[i][j] == 'T') target = new int[]{i, j};
                if(grid[i][j] == 'S') player = new int[]{i, j};
            }
        }
        Set<List<Integer>> seen = new HashSet<>();
        
        Deque<int[]> dq = new LinkedList<>();
        dq.add(new int[]{box[0], box[1], player[0], player[1]});
        seen.add(new ArrayList<>(Arrays.asList(box[0], box[1], player[0], player[1])));
        
        int distance = 0;
        
        while(!dq.isEmpty()){
            int sz = dq.size();
            while(sz-- > 0){
                
                int[] e = dq.poll();
                box = new int[]{e[0], e[1]};
                player = new int[]{e[2], e[3]};
                
                if(Arrays.equals(box, target)) return distance;
                
                for(int[] d : dir){
                    
                    int b0 = box[0] + d[0], b1 = box[1] + d[1];
                    
                    if(b0 >= 0 && b1 >= 0 && b0 < n && b1 < m && grid[b0][b1] != '#' && !seen.contains(new ArrayList<>(Arrays.asList(b0, b1, box[0], box[1]))) && canReach(new int[]{box[0] - d[0], box[1] - d[1]}, player, box, grid, n, m)){
                        seen.add(new ArrayList<>(Arrays.asList(b0, b1, box[0], box[1])));
                        dq.add(new int[]{b0, b1, box[0], box[1]});
                    }
                }
            }
            distance++;
        }
        return -1;
    }
    private boolean canReach(int[] dest, int[] player, int[] box, char[][] grid, int n, int m){
        Set<List<Integer>> seen = new HashSet<>();
        
        Deque<int[]> dq = new LinkedList<>();
        dq.add(player);
        
        while(!dq.isEmpty()){
            
            int[] p = dq.poll();
            if(Arrays.equals(p, dest)) return true;
            for(int[] d : dir){
                int rp = p[0] + d[0];
                int rc = p[1] + d[1];
                
                if(rp >= 0 && rc >= 0 && rp < n && rc < m && grid[rp][rc] != '#' && !seen.contains(new ArrayList<>(Arrays.asList(rp, rc))) && !Arrays.equals(new int[]{rp, rc}, box)){
                    seen.add(new ArrayList<>(Arrays.asList(rp, rc)));
                    dq.add(new int[]{rp, rc});
                }
            }
        }
        return false;
    }
}