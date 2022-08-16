class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int maxOne = 0, left = 0, right = 0;
        int n = nums.length;
        
        while(left < n && right < n){
            while(left < n && nums[left] == 0) left++;
            right = left;
            while(right < n && nums[right] == 1) right++;
            
            maxOne = Math.max(maxOne, right - left);
            left = right;
        }
        
        return maxOne;
    }
}