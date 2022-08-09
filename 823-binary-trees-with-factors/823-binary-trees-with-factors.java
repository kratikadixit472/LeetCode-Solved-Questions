class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        
        Arrays.sort(arr);
        
        long count = 1;
        Map<Integer, Long> map = new HashMap<>();
        map.put(arr[0], count);
        
        for(int i = 1; i < arr.length; i++){
            
            count = 1;
            for(int n : map.keySet()){
                if(arr[i] % n == 0 && map.containsKey(arr[i] / n)){
                    
                    count += map.get(n) * map.get(arr[i] / n);
                }
            }
            map.put(arr[i], count);
        }
        
        long ans = 0;
        
        for(int key : map.keySet()){
            ans = (ans + map.get(key)) % (int)(1000000007);
        }
        return (int)ans;
    }
}