class Solution {
    
    public double frogPosition(int n, int[][] edges, int t, int target) {
        
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] e : edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        double[] prob = new double[n+1];
        LinkedList<Integer> q = new LinkedList<>();
        q.add(1);
        boolean[] vis = new boolean[n+1];
        vis[1] = true;
        prob[1] = 1.0;
        
        while(!q.isEmpty() && t-- > 0){
            int sz = q.size();
            while(sz-- > 0){
                
                int top = q.poll();
                
                int eCount = 0;
                
                for(int e : graph[top]){
                    eCount += (vis[e] == false) ? 1 : 0;
                }
                
                for(int e : graph[top]){
                    if(vis[e]) continue;
                    vis[e] = true;
                    
                    prob[e] = prob[top] / eCount;
                    q.add(e);
                }
                if(eCount > 0) prob[top] = 0.0;
            }
        }
        
        // for(double p : prob){
        //     System.out.print(p+" ");
        // }
        return prob[target];
    }
}