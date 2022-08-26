class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        
        int n  = nums.length;
        
         int first =  binarySearch(nums, target);
        int last = binarySearch(nums, target+1);
        
       
        
        return last - first > n / 2;
    }
    
    private int binarySearch(int[] nums, int target){
        
        int n  = nums.length;
        int l = 0 , r = n;
        while(l < r){
            
            int mid = (l + r) / 2;
            
            if(nums[mid] < target) {
                
                l = mid + 1;
               
            }
            else r = mid;
        }
        
        return l;
    }
}