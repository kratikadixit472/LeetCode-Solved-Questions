class Solution {
    
    long maxScore;
    int count;
    public int countHighestScoreNodes(int[] parents) {
        
        int n = parents.length;
        
        List<Integer>[] list = new ArrayList[n];
        
        for(int i = 0; i < n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i = 1; i < n; i++){
            list[parents[i]].add(i);
        }
        maxScore = 0; count = 0;
        
        DFS(0, list, n);
        
        return count;
    }
    
    private long DFS(int u, List<Integer>[] list, int n){
        
        long prod = 1, total = 0;
        
        for(int v : list[u]){
            long val = DFS(v, list, n);
            prod *= val;
            total += val;
        }
        
        long rem = (long)(n - total - 1);
        
        if(rem > 0){
            prod *= rem;
        }
        
        if(maxScore < prod){
            maxScore = prod;
            count = 1;
        }
        else if(prod == maxScore){
            count++;
        }
        return total + 1;
    }
}