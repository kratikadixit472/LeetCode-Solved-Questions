class Solution {
    public String removeKdigits(String s, int k) {
        
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(!st.isEmpty() && st.peek() > s.charAt(i)){
                while(k > 0 && !st.isEmpty() && st.peek() > s.charAt(i)){
                    st.pop();
                    k--;
                }  
            }
            st.push(s.charAt(i));
        }
        for(int i=0; i<k; ++i) {
          st.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        while(sb.length() > 1 && sb.charAt(sb.length()-1) == '0'){
            sb.deleteCharAt(sb.length()-1);
        }
        if(sb.length() == 0) return "0";
        
        return sb.reverse().toString();
    }
}