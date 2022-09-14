class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
       
        int n = pushed.length;
        Stack<Integer> st = new Stack<>();
        int j = 0;
        
        for(int i = 0; i < n; i++){
            
            st.push(pushed[i]);
            
            while(!st.isEmpty() && j < n && st.peek() == popped[j]){
                j++;
                st.pop();
            }
        }
        return st.isEmpty();
    }
}