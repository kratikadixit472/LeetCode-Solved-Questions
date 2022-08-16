class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, maxOne = 0, one = 0, cnt = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1) one++;
            
            while(i - left + 1 - one > k){
                if(nums[left++] == 1) one--;
            }
            maxOne = Math.max(maxOne, i - left + 1);
        }
        return maxOne;
    }
}