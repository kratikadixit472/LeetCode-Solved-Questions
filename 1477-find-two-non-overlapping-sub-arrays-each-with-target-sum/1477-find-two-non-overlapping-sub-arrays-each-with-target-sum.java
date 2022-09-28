class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        
        int n = arr.length;
        int sum = 0;
        int[] best = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);
        
        int result = Integer.MAX_VALUE, bestSoFar = Integer.MAX_VALUE;
        int start = 0;
        
        sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            
            while(sum > target){
                sum -= arr[start++];
            }
            
            if(sum == target){
                if(start > 0 && best[start-1] != Integer.MAX_VALUE){
                    result = Math.min(result, best[start-1] + i - start + 1);
                }
                bestSoFar = Math.min(bestSoFar, i - start + 1);
            }
            best[i] = bestSoFar;
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
