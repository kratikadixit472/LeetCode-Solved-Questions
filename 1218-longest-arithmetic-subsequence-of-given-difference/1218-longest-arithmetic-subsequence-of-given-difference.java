class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        
        int n = arr.length, max = 1;
        Map<Integer, Integer> map = new HashMap<>();
        int[] dp = new int[n];
        map.put(arr[n-1], 1);
        dp[n-1] = 1;
        // Arrays.fill(dp, 1);
        
        for(int i = n-2; i>=0; i--){
            int oldVal = map.getOrDefault(arr[i], 0);
            // if(map.containsKey(arr[i] + difference)){
                int newVal = 1 + map.getOrDefault(arr[i] + difference, 0);
                dp[i] = Math.max(oldVal, newVal);
                map.put(arr[i], dp[i]);
            // }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}