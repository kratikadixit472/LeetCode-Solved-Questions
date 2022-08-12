class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        List<Integer>[] graph = new ArrayList[n];
        
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] pre : edges){
            graph[pre[0]].add(pre[1]);
            graph[pre[1]].add(pre[0]);
        }
        
        int vis[] = new int[n];
        Arrays.fill(vis, -1);
        int cnt = 0;
        
        for(int i = 0; i < n; i++){
             if(vis[i] == -1){
                 if(cnt == 1) return false;
                 //System.out.print(i +" ");
                 cnt++;
                if(isCycle(0, graph, vis)) return false;
             }
            //else return false;
        }
        return true;
    }
    
    private boolean isCycle(int src, List<Integer>[] graph, int[] vis){
        
        vis[src] = 0;
        
        for(int e : graph[src]){
            if(vis[e] == -1){
                if(isCycle(e, graph, vis)) return true;
            }
            else if(vis[e] == 1) return true;
        }
        
        vis[src] = 1;
        return false;
    }
}