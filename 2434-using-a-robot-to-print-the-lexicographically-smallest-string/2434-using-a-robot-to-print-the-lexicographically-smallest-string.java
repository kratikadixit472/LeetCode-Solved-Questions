class Solution {
    public String robotWithString(String s) {
        int[] frq = new int[26];
        
        Stack<Character> st = new Stack<>();
        
        for(char ch : s.toCharArray()){
            frq[ch-'a']++;
        }
        StringBuilder ans = new StringBuilder();
        
        for(char c : s.toCharArray()){
            frq[c-'a']--;
            st.push(c);
            while(!st.isEmpty() && st.peek() <= lower(frq)){
                ans.append(st.peek());
                st.pop();
            }
        }
        while(!st.isEmpty()){
            ans.append(st.peek());
            st.pop();
        }
        return ans.toString();
    }
    private char lower(int[] frq){
        for(int i = 0; i < 26; i++){
            if(frq[i] > 0) return (char)(i+'a');
        }
        return 'a';
    }
}