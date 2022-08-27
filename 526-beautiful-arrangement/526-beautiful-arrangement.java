class Solution {
    
    int count = 0;
    
    public int countArrangement(int n) {
        boolean[] vis = new boolean[n+1];
        calculate(1, vis, n);
        return count;
    }
    
    private void calculate(int pos, boolean[] vis, int n){
        
        if(pos == n + 1){
            count++;
            return;
        }
        
        for(int i = 1; i <= n; i++){
            if(!vis[i] && (i % pos == 0 || pos % i == 0)){
                vis[i] = true;
                calculate(pos+1, vis, n);
                vis[i] = false;
            }
        }
    }
}