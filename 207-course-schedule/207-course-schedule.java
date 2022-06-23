class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        
        for(int i=0; i<numCourses; i++){
            graph[i] = new ArrayList<Integer>();
        }
        
        for(int[] pair : prerequisites){
            graph[pair[0]].add(pair[1]);
        }
        
        int[] vis = new int[numCourses];
        Arrays.fill(vis, -1);
        Set<Integer> set  = new HashSet<>();
        
        for(int i=0; i<numCourses; i++){
            if(vis[i] == -1){
                if(isCycle_DFS(i, vis, graph)) return false;
            } 
        }
        return true;
        
    }
    
   private boolean isCycle_DFS(int src, int[] vis, List<Integer>[] graph){
       
       if(vis[src] == 1) return false;
       
       vis[src] = 0;
       boolean res = false;
       
       for(int v : graph[src]){
           if(vis[v] == -1){
               res = res || isCycle_DFS(v, vis, graph);
           }
           else if(vis[v] == 0) return true;
       }
       
       vis[src] = 1;
       return res;
    }
}