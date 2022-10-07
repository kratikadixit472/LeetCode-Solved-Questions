class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < tokens.length; i++){
            String curr = tokens[i];
            
            if(curr.equals("+") || curr.equals("-") || curr.equals("*") || curr.equals("/")){
                
                int b = st.pop();
                int a = st.pop();
                int res = 0;
                
                if(curr.equals("+")){
                    res = a + b;
                }
                else if(curr.equals("-")){
                    res = a - b;
                }
                else if(curr.equals("*")){
                    res = a * b;
                }
                else if(curr.equals("/")){
                    res = a / b;
                }
                st.push(res);
            }
            else{
                st.push(Integer.parseInt(curr));
            }
        }
        return st.pop();
    }
}