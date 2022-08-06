class Solution {
    public long minimumReplacement(int[] nums) {
        long ans = 0;
        
        int n = nums.length, prev = nums[n-1];
        
        for(int i = n - 2; i >= 0; i--){
            int noOfTime = nums[i] / prev;
            if(nums[i] % prev != 0) { 
                noOfTime++;
            }
            if(nums[i] % prev != 0){
                prev = nums[i] / noOfTime;
            }
           // System.out.println(noOfTime +" "+ prev+" ");
            ans += (long)(noOfTime - 1);
        }
        return ans;
    }
}