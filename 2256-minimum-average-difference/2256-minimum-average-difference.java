class Solution {
    public int minimumAverageDifference(int[] nums) {
        
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int ans = -1;
        
        if(nums.length == 1) return 0; 
        
        long suff = 0, pref = 0;
        for(int ele : nums) suff += ele;
    
        
        for(int i=0; i<n; i++){
            pref += nums[i];
            suff -= nums[i];
          
            int abs = 0;
            
            if(i < n-1) { abs = Math.abs((int)(pref / (i+1)) - (int)(suff / (n-i-1)));}
            else if(i == n-1) { abs = (int)(pref / (i+1));} 
            
            if(min > abs){
                min = abs;
                ans = i;
            }
        }
        return ans;
    }
}