class Solution {
    public int maxDepth(String s) {
        
        int depth = 0, ans = 0;
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                ans = Math.max(ans, ++depth);
            }
            else if(ch == ')') depth--;
        }
        return ans;
    }
}