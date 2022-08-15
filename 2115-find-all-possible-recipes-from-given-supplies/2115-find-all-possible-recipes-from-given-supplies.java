class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
        List<String> ans = new ArrayList<>();
        
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();
        
        for(int i = 0; i < ingredients.size(); i++){
            for(String ingred : ingredients.get(i)){
                // System.out.print(ingred+" "+recipes[i]+",  ");
                graph.putIfAbsent(ingred, new ArrayList<>());
                graph.get(ingred).add(recipes[i]);
                indegree.put(recipes[i], indegree.getOrDefault(recipes[i], 0) + 1);
            }
        }
        
        LinkedList<String> q = new LinkedList<>();
        for(String supp : supplies){
            q.add(supp);
        }
        
        while(!q.isEmpty()){
            
            String curr = q.poll();
            // System.out.print("." + curr+", ");
            if(graph.get(curr) == null) continue;
            for(String recp : graph.get(curr)){
                indegree.put(recp, indegree.get(recp) - 1);
                if(indegree.get(recp) == 0) q.add(recp);
            }
        }
        
        for(String recp : recipes){
            if(indegree.get(recp) == 0) ans.add(recp);
        }
        
        return ans;
    }
}