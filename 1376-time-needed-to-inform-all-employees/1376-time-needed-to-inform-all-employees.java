class Solution {
    
    int maxTime = 0;
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        List<Integer>[] graph = new ArrayList[n];
        
        for(int i = 0; i< n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < n; i++){
            if(manager[i] != -1) graph[manager[i]].add(i);
        }
        
        return DFS(headID, graph, informTime);
        
    }
    
    private int DFS(int src, List<Integer>[] graph, int[] informTime){
        
        int time = 0;
        
        for(int e : graph[src]){

            time = Math.max(time, DFS(e, graph, informTime));
        }
        return  time + informTime[src];
    }
}
/*
15
0
[-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6]
[1,1,1,1,1,1,1,0,0,0,0,0,0,0,0]*/