class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int[] vis = new int[numCourses];
        List<Integer>[] graph = new ArrayList[numCourses];
        
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] p : prerequisites){
            graph[p[0]].add(p[1]);
        }
        
        LinkedList<Integer> q = new LinkedList<>();
        List<Integer> al = new ArrayList<>();
        Arrays.fill(vis, -1);
        
        for(int i = 0; i < numCourses; i++){
            if(vis[i] == -1){
                if(DFS(i, graph, vis, al)) return new int[0];
            }
        }
        
        int[] res = new int[numCourses];
        int idx = 0;
        
        for(int ele : al){
            res[idx++] = ele;
        }
        return res;
    }
    private boolean DFS(int src, List<Integer>[] graph, int[] vis, List<Integer> al){
        
        vis[src] = 0;
        
        for(int e : graph[src]){
            if(vis[e] == -1){
                if(DFS(e, graph, vis, al)) return true;
            }
            else if(vis[e] == 0) return true;
        }
        
        al.add(src);
        vis[src] = 1;
        return false;
    }
}