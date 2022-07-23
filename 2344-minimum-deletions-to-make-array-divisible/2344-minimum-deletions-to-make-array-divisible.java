class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        
        int g = numsDivide[0], tmp = 0;
        
        for(int num : numsDivide){
            while(num > 0){
                tmp = g % num;
                g = num;
                num = tmp;
            }
        }
        
        Arrays.sort(nums); 
        
        for(int i = 0; i < nums.length && nums[i] <= g; i++){
            if(g % nums[i] == 0) return i;
        }
        
       return -1;
        
    }
}