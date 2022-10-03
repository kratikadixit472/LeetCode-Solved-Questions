class Solution {
    
    int[] par;
    
    private void union(int a, int b){
        int p1 = findPar(a), p2 = findPar(b);
        
        if(p1 != p2){
            par[p1] = p2;
        }
    }
    
    private int findPar(int u){
        return (par[u] == u ? u : (par[u] = findPar(par[u])));
    }
    
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        
        par = new int[n];
        
        for(int i = 0; i < n; i++) par[i] = i;
        
        int[][] queryList = new int[queries.length][4];
        int idx = 0;
        
        for(int i = 0; i < queries.length; i++){
            int[] q = queries[i];
            queryList[i] = new int[]{q[0], q[1], q[2], i};
        }
        
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        Arrays.sort(queryList, (a, b) -> a[2] - b[2]);
        
        boolean[] ans = new boolean[queries.length];
        
        for(int i = 0, j = 0; i < queryList.length; i++){
            int[] q = queryList[i];
            
            while(j < edgeList.length && q[2] > edgeList[j][2]){
                union(edgeList[j][0], edgeList[j][1]);
                j++;
            }
            
            int p1 = findPar(q[0]), p2 = findPar(q[1]);
            
            if(p1 == p2){
                ans[q[3]] = true;
            }
        }
        return ans;
    }
}