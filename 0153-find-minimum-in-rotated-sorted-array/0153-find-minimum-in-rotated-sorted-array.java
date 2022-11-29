class Solution {
    public int findMin(int[] nums) {
        
        int n = nums.length;
        int l = 0, r = n-1;
        if(nums[l] < nums[r]) return nums[0];
        
        while(l < r){
            
            int mid = (l + r) / 2;
            if(nums[r] > nums[mid]){
                r = mid;
            }
            else if(nums[mid] >= nums[l]){
                l = mid + 1;
            }
        }
        return nums[l];
    }
}