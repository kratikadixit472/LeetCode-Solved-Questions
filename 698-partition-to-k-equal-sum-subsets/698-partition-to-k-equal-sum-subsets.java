class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        int n = nums.length, sum = 0, maxEle = 0;
        
        for(int ele : nums) {
            maxEle = Math.max(maxEle, ele);
            sum += ele;
        }
        
        if(sum % k != 0 || maxEle > sum / k) return false;
        
        return canPartition(0, new boolean[n], nums, k, 0, sum / k);
    }
    private boolean canPartition(int idx, boolean[] vis, int[] nums, int k, int sum, int target){
        
        if(k == 0) return true;
        
        if(sum > target) return false;
        
        if(sum == target) return canPartition(0, vis, nums, k-1, 0, target);
        
        boolean res = false;
        for(int i = idx; i < nums.length; i++){
            if(!vis[i]){
                
                vis[i] = true;
                
                res = res || canPartition(i+1, vis, nums, k, sum+nums[i], target);
                
                vis[i] = false;
            }
            
        }
        return res;
    }
}