class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        
        int n = queries.length;
        int[] ans = new int[n];
        int idx = 0;
        int sum = 0;
        
        for(int ele : nums) if(ele % 2 == 0) sum += ele;
        
        for(int[] q : queries){

            int val = q[0], index = q[1];
            if(nums[index] % 2 == 0) sum -= nums[index];
            nums[index] += val;
            if(nums[index] % 2 == 0) sum += nums[index];
            ans[idx++] = sum;
        }
        return ans;
    }
}