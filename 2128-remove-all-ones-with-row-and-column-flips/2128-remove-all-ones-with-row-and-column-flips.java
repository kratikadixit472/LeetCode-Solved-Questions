class Solution {
    public boolean removeOnes(int[][] grid) {
        int n = grid.length;
        
        // if(n <= 1) return true;
        
        for(int i = 1; i < n; i++){
            if(isSame(grid[0], grid[i], n) || isFlip(grid[0], grid[i], n)) continue;
            else return false;
        }
        
        return true;
    }
    
    private boolean isSame(int[] a, int[] b, int n){
        
        for(int i = 0; i < a.length; i++){
            if(a[i] != b[i]) return false;
        }
        return true;
    }
    private boolean isFlip(int[] a, int[] b, int n){
        
        for(int i = 0; i < a.length; i++){
            if(a[i] + b[i] != 1) return false;
        }
        return true;
    }
}