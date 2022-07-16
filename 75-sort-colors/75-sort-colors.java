class Solution {
    public void sortColors(int[] nums) {
        
        int zero = 0, two = nums.length-1;
        
        for(int curr = 0; curr <= two; curr++){
            
            while(nums[curr] == 2 && curr < two){
                System.out.println(nums[curr]+" "+ nums[two]);
                int tmp = nums[curr];
                nums[curr] = nums[two];
                nums[two--] = tmp;
            }
            while(nums[curr] == 0 && curr > zero){
                System.out.println(nums[curr]+" "+ nums[zero]);
                int tmp = nums[curr];
                nums[curr] = nums[zero];
                nums[zero++] = tmp;
            }
            
        }
    }
    
}