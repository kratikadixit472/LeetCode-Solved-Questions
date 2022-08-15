class Solution {
    Map<String, String> parent;
    int count;
    
    public int removeStones(int[][] stones) {
        
        parent = new HashMap<>();
        count = stones.length;
        
        for(int[] stone : stones){
            String s = stone[0] +" "+stone[1];
            parent.put(s, s);
        }
        
        for(int i = 0; i < stones.length; i++){
        
        // for(int[] stone1: stones){
            for(int j = i+1; j < stones.length; j++){
                int[] stone1 = stones[i], stone2 = stones[j];
                String s1 = stone1[0]+" "+ stone1[1];
            // for(int[] stone2 : stones){
                if(i == j) continue;
                
               // String s2 = stone1[0] +" "+ stone1[1];
                if(stone1[0] == stone2[0] || stone1[1] == stone2[1]){
                    String s2 = stone2[0] +" "+ stone2[1];
                    union(s1, s2);
                }
            }
        
        }
        
        return stones.length - count;
    }
    
    private void union(String s1, String s2){
        
        String p1 = findPar(s1), p2 = findPar(s2);
        if(!p1.equals(p2)){
            parent.put(p2, p1);
            count--;
        }
    }
    
    private String findPar(String s){
        if(!parent.get(s).equals(s)){
            parent.put(s, findPar(parent.get(s)));
        }
        return parent.get(s);
    }
}