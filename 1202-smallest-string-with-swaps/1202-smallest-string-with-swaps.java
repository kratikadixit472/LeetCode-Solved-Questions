class Solution {
    
    int[] par, w;
    
    private int findPar(int u){
        return (par[u] == u) ? u : (par[u] = findPar(par[u]));
    }
    
    private void union(int x, int y){
        int p1 = findPar(x), p2 = findPar(y);
        
        if(p1 != p2){
            if(w[p1] > w[p2]){
                par[p2] = p1;
                w[p1] += w[p2];
            }
            else {
                par[p1] = p2;
                w[p2] += w[p1];
            }
        }
    }
    
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        
        int n = s.length();
        
        par = new int[n];
        w = new int[n];
        
        for(int i = 0; i < n; i++){
            par[i] = i;
            w[i] = 1;
        }
        
        for(List<Integer> p : pairs){
            int x = p.get(0);
            int y = p.get(1);
            
            union(x, y);
            
        }
        
        for(int i = 0 ; i < s.length(); i++){
            int root = findPar(i);
            map.putIfAbsent(root, new PriorityQueue<>());
            map.get(root).offer(s.charAt(i));
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            int root = findPar(i);
            
            PriorityQueue<Character> characters = map.get(root);
            if(characters.isEmpty()) continue;
            
            char currMin = characters.poll();
            sb.append(currMin);
        }
        return sb.toString();
    }
}