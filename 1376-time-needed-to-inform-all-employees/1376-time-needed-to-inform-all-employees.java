class Solution {
    boolean[] vis;
    int maxTime = 0;
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        List<Integer>[] graph = new ArrayList[n];
        vis = new boolean[n];
        
        for(int i = 0; i< n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < n; i++){
            if(manager[i] != -1) graph[manager[i]].add(i);
        }
        
        DFS(n, headID, graph, informTime, 0);
        
        return maxTime;
    }
    private void DFS(int n, int src, List<Integer>[] graph, int[] informTime, int time){
        
        vis[src] = true;
        //int time = 0;
        
        for(int e : graph[src]){
            if(vis[e]) continue;
            //time += informTime[src];
            //System.out.print("time->" + time + " "+ e+ " ");
            DFS(n, e, graph, informTime, time + informTime[src]);
        }
        maxTime = Math.max(time, maxTime);
        System.out.println();
        //return time;
    }
}
/*
15
0
[-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6]
[1,1,1,1,1,1,1,0,0,0,0,0,0,0,0]*/