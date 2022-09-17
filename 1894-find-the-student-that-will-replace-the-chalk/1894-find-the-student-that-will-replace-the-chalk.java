class Solution {
    public int chalkReplacer(int[] chalk, int s) {
        
        int n = chalk.length;
        long k = s;
        long[] preSum = new long[n];
        
        preSum[0] = chalk[0];
        for(int i = 1; i < n; i++){
            preSum[i] = preSum[i-1] + chalk[i];
        }
        k = k % preSum[n-1];
        
        if(k == 0) return 0;
        
        int l = 0, r = n-1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            
            if(preSum[mid] - k == 0) return mid+1;
            else if( k - preSum[mid] < 0) r = mid-1;
            else l = mid+1;
        }
        return l;
    }
}