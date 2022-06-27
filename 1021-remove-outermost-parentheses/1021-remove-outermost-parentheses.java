class Solution {
    public String removeOuterParentheses(String s) {
        
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' && cnt++ > 0) sb.append(ch);
            else if(ch == ')' && cnt-- > 1) sb.append(ch);
        }
        return sb.toString();
    }
}