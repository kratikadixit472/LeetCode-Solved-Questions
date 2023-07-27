class Solution {
    public long maxRunTime(int n, int[] batteries) {
        
        long pow = 0;
        
        for(int b : batteries){
            pow += b;
        }
        
        long l = 1, r = pow / n;
        
        while(l < r){
            long mid = (r - (r - l) / 2);
            
            long extra = 0;
            
            for(int b : batteries){
                extra += Math.min(b, mid);
            }
            
            if(extra >= (long)(n * mid)) {
                l = mid;
            }
            else r = mid - 1;
        }
        return l;
    }
}