class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] pre : prerequisites){
            graph[pre[0]].add(pre[1]);
        }
        
        int vis[] = new int[numCourses];
        Arrays.fill(vis, -1);
        
        for(int i = 0; i < numCourses; i++){
            if(vis[i] == -1){
                if(isCycle(i, graph, vis)) return false;
            }
        }
        return true;
    }
    
    private boolean isCycle(int src, List<Integer>[] graph, int[] vis){
        
        vis[src] = 0;
        
        for(int e : graph[src]){
            if(vis[e] == -1){
                if(isCycle(e, graph, vis)) return true;
            }
            else if(vis[e] == 0) return true;
        }
        
        vis[src] = 1;
        return false;
    }
}