class Solution {
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        List<Integer>[] graph = new ArrayList[n];
        
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        int informT = 0;
        for(int i = 0; i < n; i++){
            if(manager[i] == -1) continue;
            informT = Math.max(informT, DFS(i, manager, informTime));
        }
        return informT;

    }
    private int DFS(int e, int[] m, int[] t){
        if(m[e] != -1){
            t[e] += DFS(m[e], m, t);
            m[e] = -1;
        }
        return t[e];
    }
}
