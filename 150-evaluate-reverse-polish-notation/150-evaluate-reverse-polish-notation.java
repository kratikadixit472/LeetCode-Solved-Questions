class Solution {
    public int evalRPN(String[] tokens) {
        
        int n = tokens.length;
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < n; i++){
            
            if((!tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("+") && !tokens[i].equals("/"))){
                st.push(Integer.valueOf(tokens[i]));
            }
            
            else if(st.size() > 1){
                int b = st.pop();
                int a = st.pop();
                
                int res = 0;
                
                if(tokens[i].equals("+")) {
                    res = a + b;
                }
                else if(tokens[i].equals("-")) {
                    res = (a - b);
                }
                else if(tokens[i].equals("*")){
                    res = (a * b);
                }
                else if(tokens[i].equals("/")) {
                    res = (a / b);
                }
                st.push(res);
            }
            
        }
        return st.pop();
    }
}