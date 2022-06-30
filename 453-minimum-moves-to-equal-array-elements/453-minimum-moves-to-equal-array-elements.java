class Solution {
    public int minMoves(int[] nums) {
        
        if(nums.length <= 1) return 0;
        
        Arrays.sort(nums);
        int min = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            min = Math.min(min, nums[i]);
        }
        
        int ans = 0;
        
        for(int ele : nums){
            ans += ele - min;
        }
        return ans;
    }
}