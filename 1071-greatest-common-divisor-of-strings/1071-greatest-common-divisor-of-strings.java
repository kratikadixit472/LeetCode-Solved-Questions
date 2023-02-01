class Solution {
    public String gcdOfStrings(String str1, String str2) {
        
        int n = str1.length(), m = str2.length();
        
        for(int i = Math.min(n, m); i >= 1; i--){
            if(isCommon(str1, str2, i)){
                return str1.substring(0, i);
            }
        }
        return "";
    }
    
    private boolean isCommon(String s1, String s2, int k){
        int len1 = s1.length(), len2 = s2.length();
        
        if(len1 % k > 0 || len2 % k > 0) return false;
        
        int n1 = len1 / k, n2 = len2 / k;
        String base = s1.substring(0, k);
        
        return s1.equals(join(base, n1)) && s2.equals(join(base, n2));
    }
    
    private String join(String s, int n){
        String res = "";
        for(int i = 0; i < n; i++){
            res += s;
        }
        return res;
    }
}