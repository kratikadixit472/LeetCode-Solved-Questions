class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();
        
        for(String s : strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch); String newS = new String(ch);
            if(map.containsKey(newS)){
                map.get(newS).add(s);
            }
            else{
                map.put(newS, new ArrayList<>()); map.get(newS).add(s);
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        
        for(List<String> al : map.values()){
            ans.add(al);
        }
        
        return ans;
    }
}