class Solution {
    public String getHint(String secret, String guess) {
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(char ch : secret.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        
        int cows = 0, bulls = 0;
        
        for(int i = 0; i < guess.length(); i++){
            char ch = guess.charAt(i);
            
            if(map.containsKey(ch)){
                if(secret.charAt(i) == ch){
                    bulls++;
                    
                    if(map.get(ch) <= 0) {
                        cows--;
                    }
                }
                else{
                    if(map.get(ch) > 0){
                        cows++;
                        
                    }
                }
                map.put(ch, map.getOrDefault(ch, 0) - 1);
            }
        }
        return Integer.toString(bulls)+"A"+Integer.toString(cows)+"B";
    }
}