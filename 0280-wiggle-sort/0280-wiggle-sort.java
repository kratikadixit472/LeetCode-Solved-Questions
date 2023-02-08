class Solution {
    public void wiggleSort(int[] nums) {
        
        int n = nums.length;
        Arrays.sort(nums);
        
        for(int i = 1;  i < n-1; i += 2){
            int tmp = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = tmp;
        }
    }
}