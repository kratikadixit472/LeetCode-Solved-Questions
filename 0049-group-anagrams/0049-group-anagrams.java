class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for(String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String ss = new String(c);
            map.putIfAbsent(ss, new ArrayList<>());
            map.get(ss).add(s);
        }
        
        for(String s : map.keySet()){
            ans.add(map.get(s));
        }
        return ans;
    }
}