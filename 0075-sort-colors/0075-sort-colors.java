class Solution {
    public void sortColors(int[] nums) {
        int one = 0, two = 0, zero = 0;
        
        for(int ele : nums){
            if(ele == 1) one++;
            else if(ele == 2) two++;
            else zero++;
        }
        
        int idx = 0;
        
        while(zero-- > 0){
            nums[idx++] = 0;
        }
        while(one-- > 0){
            nums[idx++] = 1;
        }   
        while(two-- > 0){
            nums[idx++] = 2;
        } 
    }
}