class Solution {
    public int minimumCost(int n, int[][] highways, int discounts) {
        
        List<int[]>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] high : highways){
            graph[high[0]].add(new int[]{high[1], high[2]});
            graph[high[1]].add(new int[]{high[0], high[2]});
        }
        int[][] minDis = new int[n][discounts+1];
        
        for(int[] d : minDis) Arrays.fill(d, Integer.MAX_VALUE);
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        q.add(new int[]{0, 0, 0});
        minDis[0][0] = 0;
        
        while(!q.isEmpty()){
            int[] top = q.poll();
            
            int curr = top[0], cost = top[1], dis = top[2];
            
            if(curr == n-1) return cost;
            
            for(int[] ngbr : graph[curr]){
                
                int next = ngbr[0], w = ngbr[1];
                
                if(minDis[next][dis] > cost + w){
                    minDis[next][dis] = cost + w;
                    q.add(new int[]{next, cost + w, dis});
                }
                if(dis < discounts && minDis[next][dis+1] > cost + w / 2){
                    minDis[next][dis+1] = cost + w / 2;
                    q.add(new int[]{next, cost + w / 2, dis+1});
                }
            }
        }
        return -1;
    }
}