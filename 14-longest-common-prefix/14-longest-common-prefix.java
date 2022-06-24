class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < strs[0].length(); i++){
            char ch = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++){
                if(!checkPrefix(strs[j], strs[0], i)) return sb.toString();
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }
    
    private boolean checkPrefix(String a, String b, int idx){
        
        if(idx >= a.length()) return false;
        
        for(int i = 0; i <= idx ; i++){
            if(a.charAt(i) != b.charAt(i)) return false;
        }
        
        return true;
    }
}