class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        List<int[]>[] graph = new ArrayList[n+1];
        
        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] time : times){
            graph[time[0]].add(new int[]{time[1], time[2]});
        }
        
        return dikshtraAlgo(k, n, graph);
    }
    
   
    private int dikshtraAlgo(int src, int n, List<int[]>[] graph){
        
        int res = 0, N = n;
        // int[] dis = new int[n+1];
        boolean[] vis = new boolean[n+1];
        
        // Arrays.fill(dis, (int)(1e8));
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        pq.add(new int[]{src, 0});
        
        while(!pq.isEmpty()){
                
            int[] top = pq.poll();
            
            int vtx = top[0], wsf = top[1];
            
            if(vis[vtx]) continue;
            
            vis[vtx] = true;
            // dis[vtx] = wsf;
            res = Math.max(wsf, res);
            N--;
                
            for(int[] e : graph[vtx]){
                int v = e[0], w = e[1];
                if(!vis[v]) pq.add(new int[]{v, w + wsf});
            }
        }
        
//         int max = Integer.MIN_VALUE;
        
//         for(int i = 1 ; i <= n; i++){
            
//             max = Math.max(max, dis[i]);
//             if(max == (int)(1e8)) return -1;
//         }
        return (N != 0 ) ? -1 : res;
    }
}