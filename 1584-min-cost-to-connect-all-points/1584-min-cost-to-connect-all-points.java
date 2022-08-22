class Solution {
    
    int[] par;
    
    private int findPar(int u){
        return ((par[u] == u) ? u : (par[u] = findPar(par[u])));
    }
    
    private int getdistance(int[] p, int[] p1){
        return Math.abs(p[0] - p1[0]) + Math.abs(p[1] - p1[1]);
    }
    
    public int minCostConnectPoints(int[][] points) {
        
        List<int[]> list = new ArrayList<>();
        
        int cost = 0;
        
        par = new int[points.length];
        for(int i = 0; i < points.length; i++){
            par[i] = i;
        }
        
        for(int i = 0 ; i < points.length; i++){
            for(int j = i+1; j < points.length ; j++){
                list.add(new int[]{i, j, getdistance(points[i], points[j])});
            }
        }
        
        Collections.sort(list, (a, b) -> a[2] - b[2]);
        
        for(int i = 0; i < list.size(); i++){
            int[] curr = list.get(i);
            int s = curr[0], d = curr[1], dis = curr[2];
            int p1 = findPar(s), p2 = findPar(d);
            
            if(p1 != p2){
                par[p2] = par[p1];
                cost += dis;
            }
        }
        return cost;
    }
}