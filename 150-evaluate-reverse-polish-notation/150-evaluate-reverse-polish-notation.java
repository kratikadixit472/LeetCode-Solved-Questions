class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> st = new Stack<>();
        
        for(String s : tokens){
            if(!s.equals("+") && !s.equals("*") && !s.equals("-") && !s.equals("/")){
                st.push(Integer.valueOf(s));
            }
            else{
                int b = st.pop();
                int a = st.pop();
                if(s.equals("+")){
                    int c = a + b;
                    st.push((c));
                }else if(s.equals("*")){
                    int c = a * b;
                    st.push((c));
                }else if(s.equals("/")){
                    int c = a / b;
                    st.push((c));
                }else if(s.equals("-")){
                    int c = a - b;
                    st.push((c));
                }
            }
            
        }
        return st.pop();
    }
}