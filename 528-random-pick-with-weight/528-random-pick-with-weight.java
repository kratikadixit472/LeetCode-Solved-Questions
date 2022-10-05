class Solution {

    int[] cum;
    int n, totalSum;
    Random rand = new Random();
    
    public Solution(int[] w) {
        n = w.length;
        cum = new int[n];
        totalSum = 0;
        
        for(int i = 0; i < n; i++){
            totalSum += w[i];
            cum[i] = totalSum;
        }
    }
    
    public int pickIndex() {
        int idx = rand.nextInt(totalSum)+1;
        int l = 0, r = n-1;
        while(l < r){
            int mid = (l + r) / 2;
            if(cum[mid] == idx) return mid;
            if(cum[mid] < idx) l = mid+1;
            else r = mid;
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */