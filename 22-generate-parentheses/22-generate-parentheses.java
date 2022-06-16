class Solution {
    
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        
        backtrack("", 0, 0, n);
        
        return ans;
    }
    
    private void backtrack(String s, int open, int close, int n){
        
        if(s.length() == 2*n) {
            ans.add(s);
            return;
        }
        
        if(open < n) backtrack(s+"(", open+1, close, n);
        if(close < open) backtrack(s+")", open, close+1, n);
    }
}