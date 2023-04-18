class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0, k= 0, n = word1.length(), m = word2.length();
        
        while(i < n && j < m){
            if(k % 2 == 0){
                sb.append(word1.charAt(i++));
            }
            else{
                sb.append(word2.charAt(j++));
            }
            k++;
        }
        if(i < n){
            sb.append(word1.substring(i, n));
        }
        if(j < m){
            sb.append(word2.substring(j, m));
        }
        return sb.toString();
    }
}