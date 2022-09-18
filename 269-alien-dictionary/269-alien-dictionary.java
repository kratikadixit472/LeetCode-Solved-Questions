class Solution {
    public String alienOrder(String[] words) {
        
        int n = words.length;
        Map<Character, Integer> indegree = new HashMap<>();
        Map<Character, List<Character>> graph = new HashMap<>();
        
        for(String word : words){
            for(char c : word.toCharArray()){
                graph.putIfAbsent(c, new ArrayList<>());
                indegree.put(c, 0);
            }
        }
        
        for(int i = 0; i < n-1; i++){
            String w1 = words[i], w2 = words[i+1];
            
            if(w1.length() > w2.length() && w1.startsWith(w2)) return "";
            
            for(int k = 0; k < Math.min(w1.length(), w2.length()) ;k++){
                char c1 = w1.charAt(k), c2 = w2.charAt(k);
                if(c1 != c2){
                    graph.get(c1).add(c2);
                    indegree.put(c2, indegree.getOrDefault(c2, 0) + 1);
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        LinkedList<Character> q = new LinkedList<>();
        
        for(char key : indegree.keySet()){
            if(indegree.get(key) == 0) q.add(key);
        }
        
        while(!q.isEmpty()){
            char top = q.poll();
            sb.append(top);
            
            for(char c : graph.get(top)){
                indegree.put(c, indegree.getOrDefault(c, 0) - 1);
                if(indegree.get(c) == 0) q.add(c);
            }
        }
        if(sb.length() < indegree.size()) return "";
        return sb.toString();
    }
}