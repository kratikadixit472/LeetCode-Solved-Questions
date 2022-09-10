class Solution {
    public int minimumCost(int n, int[][] highways, int discounts) {
        
        List<int[]>[] graph = new ArrayList[n];
        
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] hway : highways){
            graph[hway[0]].add(new int[]{hway[1], hway[2]});
            graph[hway[1]].add(new int[]{hway[0], hway[2]});
        }
        int[][] vis = new int[n][discounts+1];
        for(int[] v : vis){
            Arrays.fill(v , Integer.MAX_VALUE);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0,0, 0});
        vis[0][0] = 0;
        
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int cost = top[0], city = top[1], dis = top[2];
            
            if(city == n-1) return cost;
            
            for(int[] ngbr : graph[city]){
                
                int next = ngbr[0], weight = ngbr[1];
                
                if(cost+weight < vis[next][dis]){
                    pq.add(new int[]{cost+weight, next, dis});
                    vis[next][dis] = cost + weight;
                }
                
                if(dis < discounts && cost + weight / 2 < vis[next][dis+1]){
                    pq.add(new int[]{cost + weight / 2, next, dis+1});
                    vis[next][dis+1] = cost + weight / 2;
                }
            }
        }
        return -1;
    }
}