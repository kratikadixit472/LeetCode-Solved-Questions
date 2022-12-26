class Solution {
    public boolean canJump(int[] nums) {
        int i = 0, n = nums.length;
        for (int reach = 0; i < n && i <= reach; ++i)
            reach = Math.max(i + nums[i], reach);
        return i == n;
    }
}