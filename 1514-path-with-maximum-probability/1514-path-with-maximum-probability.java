class Solution {
    class Pair{
        double prob;
        int e;
        
        public Pair(int e, double prob){
            this.prob = prob;
            this.e = e;
        }
    }
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        
        ArrayList<Pair>[] graph = new ArrayList[n];
        
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        double[] prb = new double[n];
        int idx = 0;
        
        for(int[] e : edges){
            graph[e[0]].add(new Pair(e[1], succProb[idx]));
            graph[e[1]].add(new Pair(e[0], succProb[idx++]));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> Double.compare(b.prob, a.prob));
        
        pq.add(new Pair(start, 1.0));
        
        while(!pq.isEmpty()){
            
            Pair top = pq.poll();
            int curr = top.e;
            double currP = top.prob;
            
            
            if(curr == end) return currP;
            
            for(Pair next : graph[curr]){
                
                if(prb[next.e] < currP * next.prob){
                    prb[next.e] = currP * next.prob;
                    pq.add(new Pair(next.e, currP * next.prob));
                }
            }
        }
        return 0;
    }
}
