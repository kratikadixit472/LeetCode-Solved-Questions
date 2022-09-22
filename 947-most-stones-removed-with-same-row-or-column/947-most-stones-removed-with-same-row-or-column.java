class Solution {
    
    int component = 0;
    Map<String, String> map;
    
    private String findPar(String s){
        if(!map.get(s).equals(s)) {
            map.put(s, findPar(map.get(s)));
        }
        return map.get(s);
    }
    
    private boolean sameRowCol(int i, int j, int[][] grid){
        if(grid[i][0] == grid[j][0] || grid[i][1] == grid[j][1]) return true;
        return false;
    }
    
    public int removeStones(int[][] stones) {
        
        int n = stones.length;
        
        map = new HashMap<>();
        
        for(int[] s : stones){
            String ss = s[0]+" "+ s[1];
            map.put(ss, ss);
        }
        
        for(int i = 0 ; i < n; i++){
            String s1 = stones[i][0]+" "+ stones[i][1];
            for(int j = i + 1; j < n; j++){
                
                if(sameRowCol(i, j, stones)){
                    String s2 = stones[j][0]+" "+ stones[j][1];
                    union(s1, s2);
                }
            }
        }
    
        return component;
    }
    private void union(String a, String b){
        
        String p1 = findPar(a), p2 = findPar(b);
        if(!p1.equals(p2)){
            map.put(p2, p1);
            component++;
        }
    }
}