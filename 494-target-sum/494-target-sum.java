class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int sum = 0;
        
        for(int ele : nums){
            sum += ele;
        }
        
        if(sum < target || (target + sum) < 0 || (target + sum) % 2 > 0) return 0;
        
        return calculateSum(nums, (sum + target) / 2);
    }
    
    private int calculateSum(int[] nums, int sum){
        
        int n = nums.length;
        int[] dp = new int[sum+1];
        
        dp[0] = 1;
        
        for(int ele : nums){
            for(int j = sum; j >=ele ; j--){
                // if(nums[i] <= j){
                    dp[j] += dp[j-ele];
                // }
                
            }
        }
        return dp[sum];
    }
}
//     public int findTargetSumWays(int[] nums, int s) {
//         int sum = 0;
//         for (int n : nums)
//             sum += n;
//         return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1); 
//     }   

//     public int subsetSum(int[] nums, int s) {
//         int[] dp = new int[s + 1]; 
//         dp[0] = 1;
//         for (int n : nums)
//             for (int i = s; i >= n; i--)
//                 dp[i] += dp[i - n]; 
        
//         for(int i = 0; i <= s; i++){
//             System.out.print(dp[i]zz)
//         }
//         return dp[s];
//     } 
// }
   

