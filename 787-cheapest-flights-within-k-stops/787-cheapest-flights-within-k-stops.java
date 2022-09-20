class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        List<int[]>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] flight : flights){
            graph[flight[0]].add(new int[]{flight[1], flight[2]});
        }
        
        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        pq.add(new int[]{src, 0, 0});
        stops[src] = 0;
        
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            
            int i = top[0], cost = top[1], currK = top[2];
            
            if(k+1 < currK || stops[i] < currK) continue;
            
            stops[i] = currK;
            
            if(i == dst) return cost;
            
            for(int[] next : graph[i]){
                int nextE = next[0], eCost = next[1];
                
                int nextK = currK + 1;
                
                pq.add(new int[]{nextE, cost+eCost, nextK});
                
            }
        }
        return -1;
    }
}