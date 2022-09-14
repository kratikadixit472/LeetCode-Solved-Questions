class Solution {
    public int getMaxLen(int[] nums) {
        
        int n = nums.length;
        int[] pos = new int[n];
        int[] neg = new int[n];
        pos[0] = nums[0] > 0 ? 1 : 0;
        neg[0] = nums[0] < 0 ? 1 : 0;
        int max = pos[0];
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > 0){
                pos[i] = pos[i-1] + 1;
                neg[i] = neg[i-1] > 0 ? neg[i-1] + 1 : 0;
            }
            else if(nums[i] < 0){
                pos[i] = neg[i-1] > 0 ? neg[i-1] + 1 : 0;
                neg[i] = pos[i-1] + 1;
            }
            max = Math.max(max, pos[i]);
        }
        return max;
    }
}
