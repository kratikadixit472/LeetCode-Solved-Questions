class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
        List<String> ans = new ArrayList<>();
        Map<String, List<String>> graph = new HashMap<>();
        Map<String , Integer> indegree = new HashMap<>();
        
        for(int i = 0; i < ingredients.size(); i++){
            List<String> al = ingredients.get(i);
            for(String ingred : al){
                graph.putIfAbsent(ingred, new ArrayList<>()); 
                graph.get(ingred).add(recipes[i]);
                indegree.put(recipes[i], indegree.getOrDefault(recipes[i], 0)+1);
            }
        }
        
        LinkedList<String> q = new LinkedList<>();
        
        for(String supply : supplies){
            q.add(supply);
        }
        
        while(!q.isEmpty()){
            
            String top = q.poll();
            if(graph.get(top) == null) continue;
            
            for(String rcp : graph.get(top)){
                indegree.put(rcp, indegree.getOrDefault(rcp, 0) - 1);
                if(indegree.get(rcp) == 0) q.add(rcp);
            }
        }
        
        for(String rcp : indegree.keySet()){
            if(indegree.get(rcp) == 0) ans.add(rcp);
        }
        return ans;
    }
}