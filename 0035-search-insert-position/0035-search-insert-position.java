class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        
        int l = 0, r = n-1;
        while(l <= r){
            int mid = (l + r) / 2;
            if(mid > 0 && nums[mid-1] < target && nums[mid] >= target) return mid;
            
            else if(nums[mid] < target) l = mid + 1;
            else r = mid-1;
        }
        return l;
    }
}