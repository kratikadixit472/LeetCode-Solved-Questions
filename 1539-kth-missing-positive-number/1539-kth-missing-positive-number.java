class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        if(k <= arr[0] - 1) return k;
        
        int n = arr.length;
        k -= arr[0] - 1;
        
        for(int i = 0; i < arr.length - 1; i++){
            int diff = arr[i+1] - arr[i] - 1;
            if(diff >= k){
                return arr[i] + k;
            }
            
            k -= diff;
        }
        
        return arr[n-1] + k;
    }
}