class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        
        int total = 0, n = arr.length;
        
        for(int i = 0; i < n; i++){
            total += ((n - i) * (i + 1) + 1) / 2 * arr[i];
        }
        return total;
    }
}
