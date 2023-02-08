class Solution {
    public void wiggleSort(int[] nums) {
        
        int n = nums.length;
        
        for(int i = 0;  i < n-1; i++){
            if(i % 2 == 0 && nums[i] > nums[i+1] || (i % 2 == 1 && nums[i] < nums[i+1])){
                int tmp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = tmp;
            }
            
        }
    }
}