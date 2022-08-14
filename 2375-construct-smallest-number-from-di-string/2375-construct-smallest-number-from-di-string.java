class Solution {
    public String smallestNumber(String pattern) {
        
        Stack<Integer> st = new Stack<>();
        String ans = "";
        
        for(int i = 0; i <= pattern.length(); i++){
            st.add(i + 1);
            if(i == pattern.length() || pattern.charAt(i) == 'I'){
                while(!st.isEmpty()){
                    ans += String.valueOf(st.peek());
                    st.pop();
                }
            }
        }
        return ans;
    }
}