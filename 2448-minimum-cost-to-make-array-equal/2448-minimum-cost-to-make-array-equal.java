class Solution {
    public long minCost(int[] nums, int[] cost) {
        
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        
        for (int num : nums) {
            left = Math.min(num, left);
            right = Math.max(num, right);
        }
        
        long ans = 0;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            long y1 = findCost(nums, cost, mid);
            long y2 = findCost(nums, cost, mid + 1);
            ans = Math.min(y1, y2);
            if (y1 < y2)
                right = mid;
            else
                left = mid + 1;
        }
        return ans;
    }

    private long findCost(int[] nums, int[] cost, long x) {
        long res = 0;
        for (int i = 0; i < nums.length; i++)
            res += Math.abs(nums[i] - x) * cost[i];
        return res;
    }
}