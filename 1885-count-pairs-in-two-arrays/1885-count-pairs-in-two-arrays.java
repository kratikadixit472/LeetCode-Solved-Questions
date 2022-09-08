class Solution {
    public long countPairs(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        long cnt = 0;
        int[] diff = new int[n];
        
        for(int i = 0; i < n; i++){
            diff[i] = nums1[i] - nums2[i];
        }
        Arrays.sort(diff);
        
        int left = 0, right = n-1;
        while(left < right){
            if(diff[right] + diff[left] > 0){
                cnt += (right - left) ;
                right--;
            }
            else left++;
        }
        return cnt ;
    }
}