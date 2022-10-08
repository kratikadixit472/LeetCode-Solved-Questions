class Solution {
    public int maximumScore(int[] scores, int[][] edges) {
        
        int n = scores.length;
        PriorityQueue<Integer>[] graph = new PriorityQueue[n];
        
        for(int i = 0; i < n; i++){
            graph[i] = new PriorityQueue<>((a, b) -> scores[a] - scores[b]);
        }
        
        for(int[] e : edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
            if(graph[e[0]].size() > 3) graph[e[0]].poll();
            if(graph[e[1]].size() > 3) graph[e[1]].poll();
        }
        
        int maxSum = -1;
        
        for(int[] e : edges){
            for(int i : graph[e[0]]){
                for(int j : graph[e[1]]){
                    if(i != j && i != e[1] && j != e[0]){
                        maxSum = Math.max(maxSum, scores[e[0]] + scores[e[1]] + scores[i] + scores[j]);
                    }
                }
            }
        }
        return maxSum;
    }
}