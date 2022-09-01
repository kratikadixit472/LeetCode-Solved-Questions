class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        
        int sum = 0, lsum = Integer.MAX_VALUE, result = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int n = arr.length;
        
        for(int i = 0; i < n; i++){
            sum += arr[i];
            map.put(sum, i);
        }
        
        sum = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
            
            if(map.containsKey(sum - target)){
                lsum = Math.min(lsum, i - map.get(sum - target));
            }
            
            if(map.containsKey(sum + target) && lsum < Integer.MAX_VALUE){
                result = Math.min(result, map.get(sum + target) - i + lsum);
            }
        }
        
        return (result == Integer.MAX_VALUE) ? -1 : result;
    }
}