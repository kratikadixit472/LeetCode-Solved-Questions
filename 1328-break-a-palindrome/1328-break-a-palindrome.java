class Solution {
    public String breakPalindrome(String palindrome) {
        
        if(palindrome.length() == 1) return "";
        
        char[] ch = palindrome.toCharArray();
       
        for(int i = 0; i < ch.length / 2; i++){
            if(ch[i] != 'a'){
                ch[i] = 'a';
                return new String(ch);
            }
        }
        
        ch[ch.length - 1] = 'b';
        return new String(ch);
    }
}