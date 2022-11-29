class Solution {
    public boolean isPalindrome(String s) {
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch) || Character.isLetter(ch)){
                sb.append(Character.toLowerCase(ch));
            }
        }
        
        int l = 0, r = sb.length()-1;
        
        while(l <= r){
            if(sb.charAt(l) != sb.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
}