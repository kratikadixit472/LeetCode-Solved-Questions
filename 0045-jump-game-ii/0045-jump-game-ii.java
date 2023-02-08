class Solution {
    public int jump(int[] nums) {
        int jump = 0;
        int maxReach = 0, currReach = 0;
        
        for(int i=0; i<nums.length-1; i++){
            
            maxReach = Math.max(maxReach, i+nums[i]);
            if(i == currReach){
                jump++;
                currReach = maxReach;
            }
            
        }
        return jump;
    }
}