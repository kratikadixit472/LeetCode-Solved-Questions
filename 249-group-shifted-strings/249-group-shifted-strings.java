class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for(String s : strings){
            String distinct = getDis(s);
            map.putIfAbsent(distinct, new ArrayList<>());
            map.get(distinct).add(s);
        }
        
        for(String key : map.keySet()){
            ans.add(map.get(key));
        }
        return ans;
    }
    
    private String getDis(String s){
        char[] ch = s.toCharArray();
       
        String ans = "";
        char prev = ch[0];
        for(int i = 1; i < ch.length; i++){
            int diff = (ch[i] - prev);
            if(diff < 0) diff += 26;
            ans = ans + "#"+ diff;
        }
        
        return ans;
    }
}