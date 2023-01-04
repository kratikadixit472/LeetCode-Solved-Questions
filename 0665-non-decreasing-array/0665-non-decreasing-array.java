class Solution {
    public boolean checkPossibility(int[] nums) {
        
        boolean flag = false;
        int n = nums.length;

        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] > nums[i]){
                if(flag) return false;
                if(i > 1 && (nums[i-2] > nums[i] && (i + 1 < n && nums[i-1] > nums[i+1]))) return false;
                flag = true;
            }
        }
        return true;
    }
}

//[3,4,2,3]
//[5,7,1,8]