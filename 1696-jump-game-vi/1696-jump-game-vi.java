class Solution {
    public int maxResult(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[n];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(0);
        dp[0] = nums[0];
        for(int i=1; i<n; i++) {
            if(dq.peekFirst() < i-k) {
                dq.pollFirst();
            }

            dp[i] = nums[i] + dp[dq.peekFirst()];

            while(!dq.isEmpty() && dp[dq.peekLast()] <= dp[i]) {
                dq.pollLast();
            }

            dq.addLast(i);
        }

        return dp[n-1];
    }
}