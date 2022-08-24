class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        int n1 = 0, n2 = nums[0], temp;
        for(int i=1; i<nums.length; i++){
            temp = Math.max(n1 + nums[i], n2);
            n1 = n2;
            n2 = temp;
        }
        return n2;
    }
}