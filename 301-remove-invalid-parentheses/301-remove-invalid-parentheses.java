class Solution {
    
    private void DFS(int i, StringBuilder sb, String s, Set<String> ans, int rmL, int rmR, int open){
        
        if(open < 0 || rmL < 0 || rmR < 0) return;
        
        if(i == s.length()){
            if(rmL == 0 && rmR == 0 && open == 0){
                ans.add(sb.toString());
            }
            return;
        }
        
        char c = s.charAt(i);
        int len = sb.length();
        
        if(c == '('){
            DFS(i+1, sb, s, ans, rmL-1, rmR, open);
            DFS(i+1, sb.append(c), s, ans, rmL, rmR, open+1);
        }
        else if(c == ')'){
            DFS(i+1, sb, s, ans, rmL, rmR-1, open);
            DFS(i+1, sb.append(c), s, ans, rmL, rmR, open-1);
        }
        else{
            DFS(i+1, sb.append(c), s, ans, rmL, rmR, open);
        }
        sb.setLength(len);
    }
    
    public List<String> removeInvalidParentheses(String s) {
        
        Set<String> ans = new HashSet<>();
        
        int rmL = 0, rmR = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') rmL++;
            else if(s.charAt(i) == ')'){
                if(rmL > 0 ) rmL--;
                else rmR++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        DFS(0, sb, s, ans, rmL, rmR, 0);
        return new ArrayList<>(ans);
    }
}