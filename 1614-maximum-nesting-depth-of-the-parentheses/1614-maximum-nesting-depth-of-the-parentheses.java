class Solution {
    public int maxDepth(String s) {
        
        int ans = 0, cnt = 0;
        //st.push(-1);
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == '('){
                ans = Math.max(ans, ++cnt);
            }
            else if(ch == ')'){
                --cnt;
            }
        }
        
        return ans;
    }
}