class Solution {
    public int[] getAverages(int[] nums, int k) {
        
        int n = nums.length;

        int[] ans = new int[n];

        Arrays.fill(ans, -1);

        long[] pref = new long[n+1];
        
        for(int i = 0; i < n; i++){
            pref[i+1] = nums[i] + pref[i];
        }
        
        for(int i = k; i < (n - k); i++){
            int lb = i - k, rb = i + k;
            
            long sum = pref[rb+1] - pref[lb];
            int avg = (int)(sum / (2 * k + 1));
            ans[i] = avg;
        }
        return ans;
    }
}