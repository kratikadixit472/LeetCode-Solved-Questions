class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        
        int minDiff = Integer.MAX_VALUE;
        int idx1 = -1, idx2 = -1;
        
        Map<String, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < wordsDict.length; i++){
            String word = wordsDict[i];
            
            if(word.equals(word1)){
                idx1 = i;
            }
            else if(word.equals(word2)){
                idx2 = i;
            }
            if(idx1 != -1 && idx2 != -1){
                minDiff = Math.min(minDiff, Math.abs(idx1 - idx2));
            }
        }
        return minDiff;
    }
}