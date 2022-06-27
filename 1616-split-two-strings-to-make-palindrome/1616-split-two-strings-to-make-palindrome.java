class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        
        return check(a, b) || check(b, a);
    }
    
    private boolean check(String a, String b){
        
        int i = 0, j = a.length()-1;
        
        while(i < j){
            if(a.charAt(i) != b.charAt(j)) break;
            i++; j--;
        }
        
        return validate(a, i, j) || validate(b, i, j);
    }
    
    private boolean validate(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) break;
            i++; j--;
        }
        return (i >= j);
    }
}