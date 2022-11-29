class Solution {
    public int arraySign(int[] nums) {
        
        int sign = 1;
        for(int ele : nums){
            if(ele == 0) return 0;
            
            if(ele < 0){
                sign = -sign;
            }
        }
        return sign;
    }
}