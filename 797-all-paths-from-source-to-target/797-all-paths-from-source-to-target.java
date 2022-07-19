class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<Integer> al = new ArrayList<>();
        al.add(0);
        allPaths(0, graph.length-1, graph, al);
        
        return ans;
    }
    
    private void allPaths(int src, int dest, int[][] graph, List<Integer> al){
        
        if(src == dest){
            ans.add(new ArrayList<>(al));
            return;
        }
        
        for(int vrt : graph[src]){
            al.add(vrt);
            allPaths(vrt, dest, graph, al);
            al.remove(al.size()-1);
        }
    }
}