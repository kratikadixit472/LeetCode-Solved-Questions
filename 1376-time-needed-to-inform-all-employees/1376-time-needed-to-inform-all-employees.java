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
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{headID, 0});
        int time = 0;
        
        while(!q.isEmpty()){
            int[] top = q.poll();
            
            int mangr = top[0], t = top[1];
            
            time = Math.max(time, t);
            
            for(int emp : graph[mangr]){
                q.add(new int[]{emp, t + informTime[mangr]});
            }
        }
        return time;
    }
}