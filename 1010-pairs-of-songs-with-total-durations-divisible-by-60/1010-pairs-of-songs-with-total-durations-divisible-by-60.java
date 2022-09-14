class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int pair = 0;
        
        for(int i = 0; i < time.length; i++){
            int key = time[i] % 60 ;
            int pairedKey = key == 0 ? 0 : 60 - key;
            
            pair += map.getOrDefault(pairedKey, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
       
        return pair;
    }
}