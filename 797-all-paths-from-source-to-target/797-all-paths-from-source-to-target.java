class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        int n = graph.length;
        // List<Integer>[] graph = new LinkedList[n];
        
        ans = new ArrayList<>();
        
        // LinkedList<Integer> q = new LinkedList<>();
        List<Integer> al = new ArrayList<>();
        al.add(0);
        DFS(0, n-1, graph, al);
        
        return ans;
    }
    private void DFS(int src, int dest, int[][] graph, List<Integer> al){
        
        if(src == dest) {
            ans.add(new ArrayList<>(al));
            return;
        }
        
        for(int ngbr : graph[src]){
            al.add(ngbr);
            DFS(ngbr, dest, graph, al);
            al.remove(al.size()-1);
        }   
    }
}