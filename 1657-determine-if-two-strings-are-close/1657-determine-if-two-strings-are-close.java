class Solution {
    public boolean closeStrings(String word1, String word2) {
        
        int[] frq1 = new int[26];
        int[] frq2 = new int[26];
        
        for(int i =0 ; i < word1.length(); i++){
            frq1[word1.charAt(i) - 'a']++;
        }
        for(int i =0 ; i < word2.length(); i++){
            frq2[word2.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < 26; i++){
            if(frq1[i] > 0 && frq2[i] == 0 || (frq2[i] > 0 && frq1[i] == 0)){
                return false;
            }
        }
        Arrays.sort(frq1);
        Arrays.sort(frq2);
        
        return Arrays.equals(frq1, frq2);
    }
}