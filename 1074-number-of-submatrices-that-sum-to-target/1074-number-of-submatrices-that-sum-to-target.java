class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] array = new int[m];
        int result = 0;
        for(int i = 0; i < n; i++) { //i is the starting column
            Arrays.fill(array, 0);
            for(int j = i; j < n; j++) { //j is the ending column
                for(int k = 0; k < m; k++) {
                    array[k] += matrix[k][j];
                }
                result += subarraySum(array, target);
            }
        }
        return result;
    }
    
    public int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        
        return result;
    }
}