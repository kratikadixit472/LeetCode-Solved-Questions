class Solution {
    
    int longestPath = 1;
    
    public int longestPath(int[] parent, String s) {
        
        int n = parent.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i = 1; i < n; i++){
            int p = parent[i];
            map.putIfAbsent(p, new ArrayList<>());

            map.get(p).add(i);
        
        }
        
        DFS(0, map, s);
        return longestPath;
    }
    
    private int DFS(int par, Map<Integer, List<Integer>> map, String s){
        
        if(!map.containsKey(par)) return 1;
        
        int longest = 0, secLongest = 0;
        
        for(int child : map.get(par)){
            int longestStartingFromChild = DFS(child, map, s);
            
            if(s.charAt(par) == s.charAt(child)) continue;
            
            if(longestStartingFromChild > longest){
                secLongest = longest;
                longest = longestStartingFromChild;
            }
            else if(longestStartingFromChild > secLongest){
                secLongest = longestStartingFromChild;
            }
        }
        longestPath = Math.max(longestPath, longest + secLongest + 1);
        
        return longest + 1;
    }
}