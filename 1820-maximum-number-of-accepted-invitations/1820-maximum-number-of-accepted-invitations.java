class Solution {
    public int maximumInvitations(int[][] grid) {
        
        int boys = grid.length, girls = grid[0].length;
        
        int[] fixedGirls = new int[girls];
        
        Arrays.fill(fixedGirls, -1);
        int res = 0;
        
        for(int i = 0; i < boys; i++){
            Set<Integer> seenGirls = new HashSet<>();
            
            if(DFS(i, fixedGirls, grid, seenGirls)){
                res++;
            }
        }
        return res;
    }
    
    private boolean DFS(int boy, int[] fixed, int[][] grid, Set<Integer> seenGirls){
        int girls = grid[0].length;
        
        for(int i = 0; i < girls; i++){
            if(grid[boy][i] == 1 && !seenGirls.contains(i)){
                seenGirls.add(i);
                if(fixed[i] == -1 || DFS(fixed[i], fixed, grid, seenGirls)){
                    fixed[i] = boy;
                    return true;
                }
            }
        }
        
        return false;
    }
}