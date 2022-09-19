class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Set<Integer>> preq = new HashMap<>();
        
        for(int i = 0; i < numCourses; i++){
            graph.put(i, new HashSet<>());
            preq.put(i, new HashSet<>());
        }
        
        int[] indegree = new int[numCourses];
        for(int[] p : prerequisites){
            graph.get(p[0]).add(p[1]);
            indegree[p[1]]++;
        }
        
        LinkedList<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) q.add(i);
        }
        
        while(!q.isEmpty()){
            int top = q.poll();
            Set<Integer> set = graph.get(top);
            
            for(int next : set){
                preq.get(next).add(top);
                preq.get(next).addAll(preq.get(top));
                
                if(--indegree[next] == 0) q.add(next);
            }
        }
        
        List<Boolean> ans = new ArrayList<>();
        
        for(int[] que : queries){
            if(preq.get(que[1]).contains(que[0])) ans.add(true);
            else ans.add(false);
        }
        return ans;
    }
}