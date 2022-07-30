class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        
        List<String> ans = new ArrayList<>();
        
        int[] maxFreqAcrossB = new int[26];
        
        for(String b : words2){
            int[] bfreq = count(b);
            
            for(int i = 0; i < 26; i++){
                maxFreqAcrossB[i] = Math.max(bfreq[i], maxFreqAcrossB[i]);
            }
        }
        
        
        for(String a : words1){
            int[] afreq = count(a);
            boolean isUniversal = true;
            for(int i = 0; i < 26; i++){
                if(maxFreqAcrossB[i] > afreq[i]) {
                    isUniversal = false;
                    break;
                }
            }
            if(isUniversal) ans.add(a);
            
        }
        return ans;
    }
    
    private int[] count(String a){
        
        int[] frq = new int[26];
        for(char c : a.toCharArray()){
            frq[c - 'a']++;
        }
        return frq;
    }
}