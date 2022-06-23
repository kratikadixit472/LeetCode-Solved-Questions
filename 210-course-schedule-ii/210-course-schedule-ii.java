class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<Integer>[] graph = new ArrayList[numCourses];
        
        for(int i = 0 ; i < numCourses ; i++){
            graph[i] = new ArrayList<Integer>();
        }
        
        for(int[] pre : prerequisites){
            graph[pre[0]].add(pre[1]);
        }
        
        int[] vis = new int[numCourses];
        List<Integer> al = new ArrayList<Integer>();
        Arrays.fill(vis, -1);
        
        for(int i = 0; i < numCourses ; i++){
            if(vis[i] == -1){
                if(isCycle(i, vis, graph, al)) return new int[0];
            }
        }
        
        int[] res = new int[numCourses];
        int idx = 0;
        
        for(int ele : al){
            res[idx++] = ele;
        }
        
        return res;
    }
    
    private boolean isCycle(int src, int[] vis, List<Integer>[] graph, List<Integer> res){
        
       // if(vis[src] == 0) return true;
        
        vis[src] = 0;
        
        for(int v : graph[src]){
            if(vis[v] == -1){
                if(isCycle(v, vis, graph, res)) return true;
            }
            else if(vis[v] == 0) return true;
        }
        
        res.add(src);
        vis[src] = 1;
        return false;
        
    }
}