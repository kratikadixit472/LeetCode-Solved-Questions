class Solution {
    public int strStr(String haystack, String needle) {
        
        int n = haystack.length();
        int threshold = n - needle.length();
        
        for(int i = 0; i <= threshold; i++){
            if(haystack.substring(i, i+needle.length()).equals(needle)) return i;
        }
        return -1;
    }
}