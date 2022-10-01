class Solution {
    public int longestMountain(int[] arr) {
        
        int left = 0, n = arr.length, ans = 0;
        
        while(left < n){
            int right = left;
            
            if(right + 1 < n && arr[right] < arr[right+1]){
                while(right + 1 < n && arr[right] < arr[right+1]) right++;
                
                if(right + 1 < n && arr[right] > arr[right+1]){
                    while(right + 1 < n && arr[right] > arr[right+1]) right++;
                    ans = Math.max(ans, right - left + 1);
                }
            }
            left = Math.max(left+1, right);
        }
        return ans;
    }
}