class Solution {
    public int longestCycle(int[] edges) {
        
        int n = edges.length;
        boolean[] vis = new boolean[n];
        
        int res = -1;
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                vis[i] = true;
                res = Math.max(res, getCycleLen(i, vis, edges));
            }
        }
        
        return res;
    }
    
    private int getCycleLen(int node, boolean[] vis, int[] edges) {
        
        int i = 0, curr = node;
        
        while(i < edges.length){
            i++;
            if(curr == -1 || !vis[curr])
                return -1;
            if(edges[curr] == node)
                return i;

            curr = edges[curr];
        }
        return -1;
    }
}