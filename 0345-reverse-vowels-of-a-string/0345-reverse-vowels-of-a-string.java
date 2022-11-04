class Solution {
    
    private boolean isVowel(char ch){
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U');
    }
                
    public String reverseVowels(String s) {
        
        char[] ch = s.toCharArray();
        int l = 0, r = s.length()-1;
        
        while(l < r){
            
            while(l < s.length() && !isVowel(ch[l])){
                l++;
            }
            while(r >= 0 && !isVowel(ch[r])){
                r--;
            }
            
            if(l < r){
                char tmp = ch[l];
                ch[l] = ch[r];
                ch[r] = tmp;
                l++;
                r--;
            }
        }
        
        return new String(ch);
    }
}