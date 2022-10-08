class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        int n = nums.length;
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++){
            int l = i+1, r = n-1;
            
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(Math.abs(target - sum) < Math.abs(minDiff)){
                    minDiff = target - sum;
                }
                if(sum < target) l++;
                else r--;
            }
        }
        return target - minDiff;
    }
}