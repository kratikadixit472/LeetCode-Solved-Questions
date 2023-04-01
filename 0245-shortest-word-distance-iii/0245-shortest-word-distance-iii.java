class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        
        int min = Integer.MAX_VALUE, prev = -1;
        boolean wd1 = false, wd2 = false;
        
        for(int i = 0; i < wordsDict.length; i++){
            
            if(wordsDict[i].equals(word1) || (wordsDict[i].equals(word2))){
                
                if(prev != -1 && (!wordsDict[prev].equals(wordsDict[i]) || word1.equals(word2))) {
                    
                    min = Math.min(min, (i - prev));
                }
                prev = i;
            }
           
        }
        return min;
    }
}