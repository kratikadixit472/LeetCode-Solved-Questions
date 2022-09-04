class Solution {
    public int rob(int[] nums) {
        
        int n1 = 0, n2 = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            int max = Math.max(n1 + nums[i], n2);
            n1 = n2;
            n2 = max;
        }
        return n2;
    }
}