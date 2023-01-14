class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0, ans = 0;
        
        for(int num : nums){
            if(num == 1){
                cnt++;
            }
            else{
                cnt = 0;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}