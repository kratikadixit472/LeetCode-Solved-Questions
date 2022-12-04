class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        int n = nums.length;
        int l = 0, r = n-1;
        while(l < r){
            int mid = (l + r) / 2;
            boolean halves = (r - mid) % 2 == 0;
            if(mid + 1 < n && nums[mid+1] == nums[mid]){
                if(halves){
                    l = mid + 1;
                }
                else{
                    r = mid - 1;
                }
            }
            else if(mid > 0 && nums[mid-1] == nums[mid]){
                if(halves){
                    r = mid - 2;
                }
                else{
                    l = mid + 1;
                }
            }
            else{
                return nums[mid];
            }
        }
        return nums[l];
    }
}