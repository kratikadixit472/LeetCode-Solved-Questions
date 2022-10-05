class Solution {
    
    List<int[]> ans = new ArrayList<>();
    
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        List<int[]>[] graph = new ArrayList[n];
        
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] e : edges){
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }

        for(int i = 0; i < n; i++){
            BFS(i, n, graph, distanceThreshold);
            
        }
        
        Collections.sort(ans, (a, b) -> (b[1] == a[1]) ? b[0] - a[0] : a[1] - b[1]);
        
        return ans.get(0)[0];
    }
    
    private void BFS(int curr, int n, List<int[]>[] graph, int threshold){
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        
        pq.add(new int[]{curr, 0});
        dis[curr] = 0;
        
        while(!pq.isEmpty()){
            
            int[] top = pq.poll();
            int cur = top[0], w = top[1];
            
            for(int[] ngbr : graph[cur]){
                int next = ngbr[0], nextW = ngbr[1];
                if(w + nextW < dis[next]){
                    dis[next] = w + nextW;
                    pq.add(new int[]{next, dis[next]});
                }
            }
        }
        
        int distance = 0;
        
        for(int i = 0; i < n; i++){
            if(i != curr && dis[i] <= threshold){
                distance++;
            }
        }

        ans.add(new int[]{curr, distance});
    }
}