class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        
        int n = properties.length;
        int maxAttack = 0;
        
        for(int[] p : properties){
            maxAttack = Math.max(maxAttack, p[0]);
        }
        
        int[] maxDefence = new int[maxAttack+2];
        
        for(int[] p : properties){
            
            maxDefence[p[0]] = Math.max(maxDefence[p[0]], p[1]);
        }
        int weak = 0;
        
        for(int i = maxAttack-1; i >=0 ; i--){
            maxDefence[i] = Math.max(maxDefence[i+1], maxDefence[i]);
        }
        
        for(int[] p : properties){
            
            if(p[1] < maxDefence[p[0] + 1]) weak++;
        }
        
        return weak;
    }
}