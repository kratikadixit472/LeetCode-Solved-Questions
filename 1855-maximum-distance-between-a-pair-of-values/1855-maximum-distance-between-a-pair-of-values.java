class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        
        int ans = 0;
        int n = nums1.length, m = nums2.length;
        
        for(int i = 0; i < n; i++){
            
            int left = i, right = m-1;
            while(left <= right){
                
                int mid = (left + right) / 2;
                
                if(nums2[mid] < nums1[i]) {
                    right = mid - 1 ;
                } 
                else {
                    left = mid + 1;
                }
                
            }
            if(right != i - 1){
                ans = Math.max(ans, right - i);
            }
        }
        return ans;
    }
}