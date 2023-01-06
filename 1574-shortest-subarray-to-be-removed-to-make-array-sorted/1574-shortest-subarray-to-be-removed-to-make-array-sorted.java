class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        
        int n = arr.length;
        int r = n-1;
        
        while(r > 0 && arr[r - 1] <= arr[r]) r--;
        int ans = r;
        
        for(int l = 0 ; l < r && (l == 0 || arr[l-1] <= arr[l]); ++l){
            
            while(r < n && arr[r] < arr[l]) ++r;
            
            ans = Math.min(ans, r - l - 1);
        }
        return ans;
    }
}