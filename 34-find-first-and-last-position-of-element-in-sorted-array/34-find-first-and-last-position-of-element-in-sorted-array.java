class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        
        res[0] = searchFirstPos(0, nums.length-1, nums, target);
        res[1] = searchSecondPos(0, nums.length-1, nums, target);
        
        return res;
    }
    
    private int searchFirstPos(int si, int li, int[] nums, int target){
        
        while(si <= li){
            int mid = (si+li) / 2;
            if(nums[mid] == target){
                if(mid-1 >= 0 && nums[mid-1] == target){
                    li = mid-1;
                }
                else{
                    return mid;
                }
            }
            else if(nums[mid] < target) si = mid+1;
            else li = mid-1;
        }
        return -1;
    }
    private int searchSecondPos(int si, int li, int[] nums, int target){
        
        while(si <= li){
            int mid = (si+li) / 2;
            if(nums[mid] == target){
                if(mid+1 < nums.length && nums[mid+1] == target){
                    si = mid+1;
                }
                else{
                    return mid;
                }
            }
            else if(nums[mid] < target) si = mid+1;
            else li = mid-1;
        }
        return -1;
    }
}