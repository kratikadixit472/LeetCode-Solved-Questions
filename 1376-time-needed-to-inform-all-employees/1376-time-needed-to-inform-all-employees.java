class Solution {
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        List<Integer>[] graph = new ArrayList[n];
        
        for(int i = 0; i< n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < n; i++){
            if(manager[i] != -1) graph[manager[i]].add(i);
        }
        int time = 0;
        
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{headID, 0});
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int man = curr[0], t = curr[1];
            
            time = Math.max(t, time);
            for(int e : graph[man]){
                q.add(new int[]{e, t + informTime[man]});
            }
        }
        return time;
    }
}
/*
15
0
[-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6]
[1,1,1,1,1,1,1,0,0,0,0,0,0,0,0]*/