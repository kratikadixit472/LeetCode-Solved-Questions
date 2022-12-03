class Solution {

    public int maxLength(List<String> arr) {
        Map<Character, Integer> map = new HashMap<>();
        return backtrack(arr, 0, map);
    }
    
    private int backtrack(List<String> arr, int pos, Map<Character, Integer> map){
        
        for(int val : map.values()){
            if(val > 1) return 0;
        }
        
        int maxLen = map.size();
        for(int i = pos ; i < arr.size(); i++){
            
            char[] word = arr.get(i).toCharArray();
            for(char c : word){
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            maxLen = Math.max(maxLen, backtrack(arr, i + 1, map));
            
            for(char c : word){
                if(map.get(c) == 1) map.remove(c);
                else {
                    map.put(c, map.get(c) - 1);
                }
            }
        }
        return maxLen;
    }
}