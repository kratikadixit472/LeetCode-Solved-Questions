class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        Map<Integer, List<int[]>> graph = new HashMap<>();
        
        for(int[] f : flights){
            graph.putIfAbsent(f[0], new ArrayList<>());
            graph.get(f[0]).add(new int[]{f[1], f[2]});
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
            
            if(graph.get(i) == null) continue;
            
            for(int[] next : graph.get(i)){
                int nextE = next[0], eCost = next[1];
                
                int nextK = currK + 1;
                
                pq.add(new int[]{nextE, cost+eCost, nextK});
                
            }
        }
        return -1;
    }
}