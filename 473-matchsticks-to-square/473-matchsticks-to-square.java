class Solution {
    public boolean makesquare(int[] matchsticks) {
        
        int sum = 0;
        
        for(int ele : matchsticks){
            sum += ele;
        }
        
        if(sum % 4 != 0) return false;
        
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        
        return checkIfMatchstick(0, matchsticks, new int[4], sum / 4);
    }
    
    private boolean checkIfMatchstick(int idx, int[] nums, int[] matchs, int target){
        
        if(idx == nums.length){
            return (matchs[0] == target && matchs[1] == target && matchs[2] == target && matchs[3] == target);
        }
        
        for(int i = 0; i < 4; i++){
            if(nums[idx] + matchs[i] > target) continue;
            
            matchs[i] += nums[idx];
            
            if(checkIfMatchstick(idx + 1, nums, matchs, target)) return true;
            
            matchs[i] -= nums[idx];
        }
        
        return false;
    }
    
    private void reverse(int[] nums){
        
        int i = 0, j = nums.length-1;
        
        while(i < j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++; j--;
        }
    }
}