class Solution {
    public String alienOrder(String[] words) {
        
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        
        for(int i = 0; i < words.length; i++){
            for(char ch : words[i].toCharArray()){
                graph.put(ch, new ArrayList<>());
                indegree.put(ch, 0);
            } 
            
        }
         
        for(int i= 0; i < words.length-1; i++){
            String word1 = words[i], word2 = words[i+1];
            
            if(word1.length() > word2.length() && word1.startsWith(word2)) return "";
            
            for(int k = 0; k < Math.min(word1.length(), word2.length()); k++){
                char par = word1.charAt(k), child = word2.charAt(k);
                if(par != child){
                    graph.get(par).add(child);
                    indegree.put(child, indegree.get(child) + 1);
                    break;
                }
            }
        }
        
        LinkedList<Character> q = new LinkedList<>();
        
        for(Character key : indegree.keySet()){
            if(indegree.get(key) == 0) q.add(key);
        }
        
        
        StringBuilder sb = new StringBuilder();
        
        while(!q.isEmpty()){
            Character ch = q.poll();
            sb.append(ch);
            
            for(Character child : graph.get(ch)){
                indegree.put(child, indegree.get(child)-1);
                if(indegree.get(child) == 0) q.add(child);
            }
        }
        
        return (sb.length() < indegree.size()) ? "" : sb.toString();
    }
}