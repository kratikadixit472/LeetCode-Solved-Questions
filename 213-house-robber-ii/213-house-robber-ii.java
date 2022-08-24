class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        if(n == 1) return nums[0];
        
        return Math.max(helper(nums, 0, n-1), helper(nums, 1, n));
    }
    
    private int helper(int[] nums, int si, int ei){
        
        int n1 = 0, n2 = nums[si];
        if(ei - si == 1) return n2;
        
        for(int i=si+1; i<ei; i++){
            int tmp = Math.max(n1 + nums[i], n2);
            n1 = n2;
            n2 = tmp;
        }
        return n2;
    }
}