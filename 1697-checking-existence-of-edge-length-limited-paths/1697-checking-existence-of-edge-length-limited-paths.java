class Solution {
    
    int[] par;
    
    private int findPar(int u){
        return (par[u] == u) ? u : (par[u] = findPar(par[u]));
    }
    
    private void union(int x, int y){
        int p1 = findPar(x), p2 = findPar(y);
        
        if(p1 != p2){
            par[p1] = par[p2];
        }
    }
    
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        
        par = new int[n];
        
        for(int i = 0; i < n; i++) par[i] = i;
        
        int[][] currQuery = new int[queries.length][4];
        
        for(int i = 0; i < queries.length; i++){
            currQuery[i] = new int[]{queries[i][0], queries[i][1], queries[i][2], i};
        }
        
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        Arrays.sort(currQuery, (a, b) -> a[2] - b[2]);
        
        boolean[] res = new boolean[queries.length];
        
        for(int i = 0, j = 0; i < currQuery.length; i++){
            int[] query = currQuery[i];
            
            while(j < edgeList.length && edgeList[j][2] < query[2]){
                union(edgeList[j][0], edgeList[j++][1]);
            }
            res[query[3]] = (findPar(query[0]) == findPar(query[1]));
        }
        return res;
    }
}