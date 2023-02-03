class Solution {
    public String decodeString(String s) {
        
        Stack<Integer> ds = new Stack<>();
        Stack<String> st = new Stack<>();
        int i = 0;
        String curr = "";
        
        while(i < s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int n = 0;
                while(Character.isDigit(s.charAt(i))){
                    n = n * 10 + (s.charAt(i++) - '0');
                }
                ds.add(n);
            }
            else if(c == '['){
                st.push(curr);
                curr = "";
                i++;
            }
            else if(c == ']'){
                int num = ds.pop();
                if(st.isEmpty()) break;
                String prev = st.pop();
                while(num-- > 0){
                    prev += curr;
                }
                curr = prev;
                i++;
            }
            else{
                curr += s.charAt(i);
                i++;
            }
        }
        return curr;
    }
}