class Solution {
    public String makeGood(String s) {
        
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            if(!st.isEmpty() && (st.peek() != s.charAt(i)) && (Character.toLowerCase(st.peek()) == (s.charAt(i)) || Character.toUpperCase(st.peek()) == (s.charAt(i)))){
                st.pop();
            }
            else{
                st.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}