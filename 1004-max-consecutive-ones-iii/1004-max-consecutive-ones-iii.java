class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, maxOne = 0, flip = 0, cnt = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) flip++;
            
            while(flip > k){
                if(nums[left++] == 0) flip--;
            }
            maxOne = Math.max(maxOne, i - left + 1);
        }
        return maxOne;
    }
}