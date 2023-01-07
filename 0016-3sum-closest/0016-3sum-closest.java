class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = Integer.MIN_VALUE, diff = Integer.MAX_VALUE;
        
        int n = nums.length;
        Arrays.sort(nums);
        
        for(int i = 0; i < n; i++){
            
            while(i != 0 && i < nums.length && nums[i-1] == nums[i]) i++;
            int l = i + 1, r = n - 1;
            while(l < r){
                
                int sum = nums[l] + nums[r] + nums[i];
                if(sum <= target){
                    if(sum == target) return sum;
                    l++;
                }
                else r--;
                if(Math.abs(diff) > Math.abs(target - sum)){
                    ans = sum;
                    diff = Math.abs(target - sum);
                }
            }
        }
        return ans;
    }
}