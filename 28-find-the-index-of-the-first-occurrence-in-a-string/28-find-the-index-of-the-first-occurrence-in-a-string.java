class Solution {
    public int strStr(String haystack, String needle) {
        
        int n = haystack.length();
        if(needle.isEmpty()) return 0;
        
        if(haystack.isEmpty() || n < needle.length()) return -1;
        
        for(int i = 0, j = 0; i < n; i++){
            char ch1 = haystack.charAt(i), ch2 = needle.charAt(j);
            if(ch1 == ch2){
                if(j == needle.length()-1) return i - j;
                j++;
            }
            else{
                i = i - j;
                j = 0;
            }
        }
        return -1;
    }
}