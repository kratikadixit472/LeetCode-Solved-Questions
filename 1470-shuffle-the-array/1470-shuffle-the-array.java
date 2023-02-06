class Solution {
    public int[] shuffle(int[] nums, int n) {
        
        int m = nums.length, i = 0, j = n, idx = 0;
        int[] ans = new int[m];
        
        while(i < n && j < m){
            ans[idx++] = nums[i++];
            ans[idx++] = nums[j++];
        }
        return ans;
    }
}