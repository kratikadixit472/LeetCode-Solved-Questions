class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        
        List<Integer>[] graph = new ArrayList[numCourses];
        
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] p : prerequisites){
            graph[p[0]].add(p[1]);
        }
        List<Boolean> ans = new ArrayList<>();
        
        for(int[] q : queries){
            if(DFS(q[0], q[1], new boolean[numCourses], graph)) ans.add(true);
            else ans.add(false);
        }
        return ans;
    }
    private boolean DFS(int src, int dest, boolean[] vis, List<Integer>[] graph){
        vis[src] = true;
        if(src == dest) return true;
        
        for(int e : graph[src]){
            if(!vis[e]) {
                if(DFS(e, dest, vis, graph)) return true;
            }
        }
        return false;
    }
}