class Solution {
    
    Map<String, String> par;
    
    private String findPar(String s){
        if(par.get(s).equals(s)) return s;
        par.put(s, findPar(par.get(s)));
        return par.get(s);
    }
    
    private boolean isRowCol(int[] a, int[] b){
        return (a[0] == b[0] || a[1] == b[1]);
    }
    
    public int removeStones(int[][] stones) {
        
        par = new HashMap<>();
        int n = stones.length;
        
        for(int i = 0; i < n; i++){
            String s = stones[i][0] +"@"+stones[i][1];
            par.put(s, s);
        }
        
        int removed = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = i +1; j < n; j++){
                if(isRowCol(stones[i], stones[j])){
                    String s1 = stones[i][0] +"@"+stones[i][1], s2 = stones[j][0] +"@"+stones[j][1];;
                    
                    String p1 = findPar(s1), p2 = findPar(s2);
                    
                    if(!p1.equals(p2)){
                        par.put(p2, p1);
                        removed++;
                    }
                }
            }
        }
        return removed;
    }
}