class Solution {
    
    int[] par;
    
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        
        int n = source.length;
        par = new int[n];
        
        for(int i = 0; i < n; i++){
            par[i] = i;
        }
        
        for(int[] allow : allowedSwaps){
            int x = findPar(allow[0]);
            int y = findPar(allow[1]);
            
            if(x != y){
                par[y] = x;
            }
        }
        int cnt = 0;
        
        for(int i = 0; i < source.length; i++){
            int num = source[i];
            int root = findPar(i);
            
            map.putIfAbsent(root, new HashMap<>());
            Map<Integer, Integer> score = map.get(root);
            
            score.put(num, score.getOrDefault(num, 0) + 1);
            
        }
        
        for(int i = 0; i < target.length; i++){
            int num = target[i];
            int root = findPar(i);
            
            Map<Integer, Integer> score = map.get(root);
            
            if(score.getOrDefault(num, 0) == 0) cnt++;
            else score.put(num, score.getOrDefault(num, 0) - 1);
            
        }
        
        return cnt;
    }
    
    private int findPar(int u){
        
        return (par[u] == u) ? u : (par[u] = findPar(par[u]));
        
    }
}