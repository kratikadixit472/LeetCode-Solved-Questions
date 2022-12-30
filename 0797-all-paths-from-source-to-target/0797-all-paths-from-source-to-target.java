class Solution {
    List<List<Integer>> ans;
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        int n = graph.length;
        
        ans = new ArrayList<>();
        List<Integer>[] adj = new ArrayList[n];
        
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < n; i++){
            int[] e = graph[i];
            for(int ele : e) {
                adj[i].add(ele);
            }
        }
        List<Integer> al = new ArrayList<>();
        al.add(0);
        DFS(0, n-1, adj, al);
        return ans;
    }
    
    private void DFS(int src, int dest, List<Integer>[] graph, List<Integer> al){
        if(src == dest){
            ans.add(new ArrayList<>(al));
            return;
        }
        if(graph[src] == null) return;
        
        for(int ngbr : graph[src]){
            al.add(ngbr);
            DFS(ngbr, dest, graph, al);
            al.remove(al.size()-1);
        }
    }
}