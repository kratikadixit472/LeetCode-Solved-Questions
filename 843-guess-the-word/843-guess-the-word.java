/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] words, Master master) {
        
        int maxGuess = 10;
        Random random = new Random();
        
        List<String> currListSearch = new ArrayList<>();
        
        for(String w : words) currListSearch.add(w);
        
        int trail = 1;
        
        while(trail <= maxGuess){
            int currentIdx = random.nextInt(currListSearch.size());
            String currentPickedWord = currListSearch.get(currentIdx);
            
            int numMatches = master.guess(currentPickedWord);
            if(numMatches == 6) return;
            
            List<String> newListSearch = new ArrayList<>();
            
            for(String s : currListSearch){
                if(countMatched(s, currentPickedWord) == numMatches){
                    newListSearch.add(s);
                }
            }
            
            currListSearch = new ArrayList<>(newListSearch);
        }
    }
    
    private int countMatched(String a, String b){
        
        int cnt = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) == b.charAt(i)) cnt++;
        }
        return cnt;
    }
}