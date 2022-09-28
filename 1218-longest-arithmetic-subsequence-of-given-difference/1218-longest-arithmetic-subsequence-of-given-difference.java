class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        
        int n = arr.length, max = 1;
        Map<Integer, Integer> map = new HashMap<>();
        // int[] dp = new int[n];
        // map.put(arr[n-1], 1);
        // dp[n-1] = 1;
        
        // for(int i = n-2; i>=0; i--){
        //     int oldVal = map.getOrDefault(arr[i], 0);
        //         int newVal = 1 + map.getOrDefault(arr[i] + difference, 0);
        //         dp[i] = Math.max(oldVal, newVal);
        //         map.put(arr[i], dp[i]);
        //     max = Math.max(max, dp[i]);
        // }
        
        for(int a : arr){
            int aVal = map.getOrDefault(a - difference, 0);
            map.put(a, aVal+1);
            max = Math.max(max, map.get(a));
        }
        
        return max;
    }
}