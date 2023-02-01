class Solution {
    public String gcdOfStrings(String str1, String str2) {
        
        int n = str1.length(), m = str2.length();
        
        if(!(str1+str2).equals(str2+str1)) return "";
        
        int len = gcd(n, m);
        return str1.substring(0, len);
    }
    
    private int gcd(int n, int m){
        
        if(m == 0) return n;
        return gcd(m, n % m);
    }
}