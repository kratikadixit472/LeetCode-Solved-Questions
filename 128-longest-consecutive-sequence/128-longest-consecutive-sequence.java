class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length <= 0) return 0;
        
        Arrays.sort(nums);
        
        int ans = 0, count = 1;
        
        for(int i = 0; i < nums.length; i++){
            
            if(i > 0 && nums[i-1] + 1 == nums[i]){
                while(i < nums.length && nums[i-1] + 1 == nums[i]){
                    count++;
                    i++;
                    while(i < nums.length && nums[i-1] == nums[i]) i++;
                }
            }
            
            ans = Math.max(ans, count);
            count = 1;
            
        }
        
        return Math.max(count, ans);
    }
}

 