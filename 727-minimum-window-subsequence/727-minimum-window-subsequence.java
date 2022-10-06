class Solution {
    public String minWindow(String s, String t) {
        
        int right = 0, tIndex = 0, minLen = Integer.MAX_VALUE;
        String result = "";
        
        while(right < s.length()){
            tIndex = 0;
            
            while(right < s.length()){
                if(s.charAt(right) == t.charAt(tIndex)) {
                    tIndex++;
                }
                if(tIndex == t.length()) {
                    break;
                }
                right++;
            }
            
            if(right == s.length()) break;
            
            int left = right;
            tIndex = t.length()-1;
            while(left >= 0){
                if(s.charAt(left) == t.charAt(tIndex)) {
                    tIndex--;
                }
                if(tIndex < 0) {
                    break;
                }
                left--;
            }
            
            if(minLen > right - left + 1){
                minLen = right - left + 1;
                result = s.substring(left, right+1);
            }
            
            right = left + 1;
        }
        
        return result;
    }
}