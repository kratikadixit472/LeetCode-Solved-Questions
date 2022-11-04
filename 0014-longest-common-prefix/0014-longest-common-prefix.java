class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < strs[0].length(); i++){
            char ch = strs[0].charAt(i);
            boolean flag = true;
            
            for(int j = 1; j < strs.length; j++){
                if(i >= strs[j].length() || strs[j].charAt(i) != ch){
                    flag = false;
                    break;
                }
            }
            if(flag){
                sb.append(ch);
            }
            else break;
        }
        return sb.toString();
    }
}