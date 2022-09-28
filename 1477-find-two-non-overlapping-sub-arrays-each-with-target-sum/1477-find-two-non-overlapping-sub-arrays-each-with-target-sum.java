class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        
        int lsum = Integer.MAX_VALUE;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            map.put(sum, i);
        }
        int result = Integer.MAX_VALUE;
        
        sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            
            if(map.containsKey(sum - target)){
                lsum = Math.min(lsum, i - map.get(sum - target));
            }
            
            if(lsum < Integer.MAX_VALUE && map.containsKey(target + sum)){
                result = Math.min(result, map.get(target + sum) - i + lsum);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
