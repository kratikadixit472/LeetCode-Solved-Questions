class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        List<int[]>[] graph = new ArrayList[n+1];
        
        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] time : times){
            graph[time[0]].add(new int[]{time[1], time[2]});
        }
        
        // Arrays.sort(graph, (a, b) -> a[1] - b[1]);
        
        int[] signal = new int[n+1];
        Arrays.fill(signal, Integer.MAX_VALUE);
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(k);
        
        signal[k] = 0;
        
        while(!q.isEmpty()){
            
            int curr = q.poll();
            
            for(int[] ngbr : graph[curr]){
                int time = ngbr[1], next = ngbr[0];
                
                int arrivalTime = signal[curr] + time;
                if(signal[next] > signal[curr] + time){
                    signal[next] = signal[curr] + time;
                    q.add(next);
                }
            }
        }
        int ans = 0;
        for(int i = 1; i <= n; i++){
            ans = Math.max(ans, signal[i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}