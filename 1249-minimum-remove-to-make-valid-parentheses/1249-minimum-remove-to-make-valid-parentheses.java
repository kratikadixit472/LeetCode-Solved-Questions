class Solution {
    public String minRemoveToMakeValid(String s) {
        
        Stack<Integer> st = new Stack<>();
        
        char[] ch = s.toCharArray();
        
        for(int i=0; i<s.length(); i++){
            char c = ch[i];
            if(c == '('){
                st.push(i);
            }
            else if(c == ')'){
                if(st.isEmpty()){
                    ch[i] = '?';
                }
                else{
                    st.pop();
                }
            }
        }
        
        while(!st.isEmpty()){
            ch[st.pop()] = '?';
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(char c : ch){
            if(c != '?') sb.append(c);
        }
        return sb.toString();
    }
}