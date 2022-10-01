class Solution {
    
    int maxProd = 0;
    
    
    public int maxProduct(String s) {
        
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        getMaxProd(0, s, sb1, sb2);
        return maxProd;
    }
    
    private void getMaxProd(int i, String s, StringBuilder sb1, StringBuilder sb2){
        
        if(i >= s.length()) {
            if(isPalindrome(sb1) && isPalindrome(sb2))
                maxProd = Math.max(maxProd, sb1.length() * sb2.length());
            return;
        }
        
        sb1.append(s.charAt(i));
        getMaxProd(i+1, s, sb1, sb2);
        sb1.deleteCharAt(sb1.length()-1);
        
        sb2.append(s.charAt(i));
        getMaxProd(i+1, s, sb1, sb2);
        sb2.deleteCharAt(sb2.length()-1);
        
        getMaxProd(i+1, s, sb1, sb2);
        
    }
    
    private boolean isPalindrome(StringBuilder sb){
        
        int l = 0, r = sb.length()-1;
        char[] ch = sb.toString().toCharArray();
        
        while(l < r){
            if(ch[l] != ch[r]) {
                return false;
            }
            l++;
            r--;
            
        }
        return true;
    }
}