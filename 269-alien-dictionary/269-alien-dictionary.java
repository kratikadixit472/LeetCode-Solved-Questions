class Solution {
    public String alienOrder(String[] words) {
        
        int n = words.length;
        Map<Character, List<Character>> map = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for(String word : words){
            for(char c : word.toCharArray()){
                map.put(c, new ArrayList<>());
                indegree.put(c, 0);
            }
            
        }
        for(int i = 0; i < n-1; i++){
            String s1 = words[i], s2 = words[i+1];
            
            if(s1.length() > s2.length() && s1.startsWith(s2)) return "";
            
            for(int j = 0; j < Math.min(s1.length(), s2.length()); j++){
                if(s1.charAt(j) != s2.charAt(j)){
                    map.get(s1.charAt(j)).add(s2.charAt(j));
                    indegree.put(s2.charAt(j), indegree.get(s2.charAt(j))+1);
                    break;
                }
            }
        }
        
        LinkedList<Character> q = new LinkedList<>();
        
        for(char key : indegree.keySet()){
            if(indegree.get(key) == 0) q.add(key);
        }
        StringBuilder ans = new StringBuilder();
        
        while(!q.isEmpty()){
            char top = q.poll();
            
            ans.append(top);
            for(char next : map.get(top)){
                indegree.put(next, indegree.getOrDefault(next,0)-1);
                if(indegree.get(next) == 0) q.add(next);
            }
        }
        
        if(ans.length() < indegree.size()) return "";
        
        return ans.toString();
    }
}