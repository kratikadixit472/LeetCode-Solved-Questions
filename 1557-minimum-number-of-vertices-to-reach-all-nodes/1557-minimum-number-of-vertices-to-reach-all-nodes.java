class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        List<Integer> ans = new ArrayList<>();
        
//         for(int i = 0 ; i < n; i++){
//             graph[i] = new ArrayList<>();
//         }
        
        int[] indegree = new int[n];
        for(List<Integer> e : edges){
            // graph[e[0]].add(e[1]);
            indegree[e.get(1)]++;
        }
        
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0) ans.add(i);
        }
        return ans;
    }
}