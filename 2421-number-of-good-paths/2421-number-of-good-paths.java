class Solution {
    
    int cnt = 0;
    int[] par;
    
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        
        int n = vals.length;
        List<Integer>[] graph = new ArrayList[n];
        par = new int[n];
        
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
            par[i] = i;
        }
        
        for(int[] e : edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        TreeMap<Integer, List<Integer>> valueToNode = new TreeMap<>();
        
        for(int i =0 ; i < n; i++){
            valueToNode.putIfAbsent(vals[i], new ArrayList<>());
            valueToNode.get(vals[i]).add(i);
        }
        
        int paths = 0;
        
        for(int value : valueToNode.keySet()){
            
            for(int node : valueToNode.get(value)){
                
                if(graph[node] == null) continue;
                
                for(int ngbr : graph[node]){
                    if(vals[node] >= vals[ngbr]){
                        union(node, ngbr);
                    }
                }
            }
        

            Map<Integer, Integer> grp = new HashMap<>();

            for(int u : valueToNode.get(value)){
                int p = findPar(u);
                grp.put(p, grp.getOrDefault(p, 0) + 1);
            }
            
            for(int key : grp.keySet()){
                int sz = grp.get(key);
                paths += sz * (sz + 1) / 2;
            }
        }
        return paths;
    }
    
    private int findPar(int u){
        return (par[u] == u) ? u : (par[u] = findPar(par[u]));
    }
    
    private void union(int x, int y){
        int p1 = findPar(x), p2 = findPar(y);
        
        if(p1 == p2) return;
        
        par[p1] = p2;
    }
}