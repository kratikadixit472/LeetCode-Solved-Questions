class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        List<String> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for(int i =0 ; i + 10 <= s.length(); i++){
            String str = s.substring(i, i + 10);
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        for(String key : map.keySet()){
            if(map.get(key) >= 2){
                ans.add(key);
            }
        }
        
        return ans;
    }
}