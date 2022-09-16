class Solution {
    public int numOfSubarrays(int[] arr) {
        
        int n = arr.length;
        int odd = 0, even = 0;
        int ans = 0;
        
        for(int i = 0; i < n; i++){
            if(arr[i] % 2 == 0){
                even++;
            }
            else if(arr[i] % 2 == 1){
                int tmp = odd;
                odd = even+1;
                even = tmp;
            }
            ans = (ans + odd) % 1000000007;
        }
        return ans;
    }
}