class Solution {
    public int findDuplicate(int[] nums) {
        
        int n = nums.length;
        int duplicate = -1, l = 0, r = n-1;
        
        while(l <= r){
            
            int mid = (l + r) / 2;
            int cnt = 0;
            
            for(int ele : nums){
                if(ele <= mid){
                    cnt++;
                }
            }
            
            if(cnt > mid){
                duplicate = mid;
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return duplicate;
    }
}