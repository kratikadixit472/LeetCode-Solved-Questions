class Solution {
    
    List<String> al = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        
        List<String> ans = new ArrayList<>();
        
        dfs(n*2, "", n);
        
        for(String s : al){
            if(isValid(s)) ans.add(s);
        }
        return ans;
    }
    
    private void dfs(int n, String str, int N){
        if(str.length() == 2*N) {
            al.add(str);
        }
        if(n <= 0) return;
        
        dfs(n-1, str+"(", N);
        dfs(n-1, str+")", N);
    }
    
    private boolean isValid(String s){
        
        Stack<Character> st = new Stack<>();
        
        for(char ch : s.toCharArray()){
            if(ch == '(') st.push(ch);
            else{
                if(st.isEmpty() || st.peek() == ')') return false;
                st.pop();
            }
        }
        return (st.isEmpty());
    
    }
}