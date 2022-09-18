class Solution {
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        List<Integer>[] graph = new ArrayList[n];
        
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < n; i++){
            if(manager[i] == -1) continue;
            graph[manager[i]].add(i);
        }
        return DFS(n, headID, graph, informTime);

    }
    private int DFS(int n, int mangr, List<Integer>[] graph, int[] t){
        int time = 0;
        for(int e : graph[mangr]){
            time = Math.max(time, t[mangr] + DFS(n, e, graph, t));
        }
        return time;
    }
}