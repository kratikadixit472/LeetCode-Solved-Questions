class Solution {

    int[] cum ;
    int totalSum;
    
    public Solution(int[] w) {
        cum = new int[w.length];
        
        for(int i = 0; i < w.length; i++){
            totalSum += w[i];
            cum[i] = totalSum;
        }
    }
    
    public int pickIndex() {
        
        double target = Math.random() * totalSum;
        int left = 0, right = cum.length-1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(cum[mid] == target) return mid;
            else if(cum[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */