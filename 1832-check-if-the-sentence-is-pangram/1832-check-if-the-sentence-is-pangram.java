class Solution {
    public boolean checkIfPangram(String sentence) {
        
        int[] frq = new int[26];
        
        for(char ch : sentence.toCharArray()){
            frq[ch-'a']++;
        }
        
        for(int f : frq){
            if(f == 0) return false;
        }
        return true;
    }
}