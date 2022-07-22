class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length <= 0) return 0;
        
        Arrays.sort(nums);
        
        int ans = 0, count = 1;
        
        for(int i = 1; i < nums.length; i++){
            
            if(nums[i-1] != nums[i]){
                if(nums[i-1] + 1 == nums[i]){
                    count++;
                }
                else{
                    ans = Math.max(ans, count);
                    count = 1;
                }
            }
        }
        
        return Math.max(count, ans);
    }
}