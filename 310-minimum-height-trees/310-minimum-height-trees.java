class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        if(n < 2){
            List<Integer> leaves = new ArrayList<>();;
            for(int i = 0; i < n; i++){
                leaves.add(i);
            }
            return leaves;
        }
        
        
        List<Set<Integer>> graph = new ArrayList<>();
        
        for(int i = 0 ; i < n; i++){
            graph.add(new HashSet<>());
        }

        int[] indegree = new int[n];
        for(int[] e : edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        List<Integer> leaves = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(graph.get(i).size() == 1) leaves.add(i);
        }
        
        int remainingNodes = n;
        
        while(remainingNodes > 2){
            remainingNodes -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            
            for(int leave : leaves){
                for(int nLeave : graph.get(leave)){
                    graph.get(nLeave).remove(leave);
                    if(graph.get(nLeave).size() == 1){
                        newLeaves.add(nLeave);
                    }
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}