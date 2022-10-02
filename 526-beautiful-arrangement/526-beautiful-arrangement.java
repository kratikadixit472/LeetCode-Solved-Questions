class Solution {
    
    int result = 0;
    
    public int countArrangement(int n) {
        boolean[] vis = new boolean[n+1];
        countBeautiful(1, n, vis);
        return result;
    }
    private void countBeautiful(int pos, int n, boolean[] vis){
        
        if(pos > n){
            result++;
            return;
        }
        
        for(int i = 1; i <= n; i++){
            
            if( !vis[i] && (i % pos == 0 || pos % i == 0)){
                vis[i] = true;
                countBeautiful(pos + 1, n, vis);
                vis[i] = false;
            }
            
        }
    }
}