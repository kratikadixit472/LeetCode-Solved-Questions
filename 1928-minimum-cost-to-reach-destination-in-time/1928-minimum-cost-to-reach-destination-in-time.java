class Solution {
    public int minCost(int maxTime, int[][] edges, int[] fees) {
        
        int n = fees.length;
        
        List<int[]>[] graph = new ArrayList[n];
        int[] minTime = new int[n];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] e : edges){
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{fees[0], 0, 0}); // fee, edge, time
        
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            
            int fee = top[0], curr = top[1], time = top[2];
            if(time >= minTime[curr]) continue;
            
            if(curr == n-1) return fee;
            
            minTime[curr] = time;
            
            for(int[] e : graph[curr]){
                
                int next = e[0], t = e[1];
                int ntime = t + time;
                
                if(ntime > maxTime) continue;
                
                else if(ntime > minTime[next]) continue;
                    
                pq.add(new int[]{fee + fees[next], next, t + time});
                
            }
        }
        return -1;
    }
}