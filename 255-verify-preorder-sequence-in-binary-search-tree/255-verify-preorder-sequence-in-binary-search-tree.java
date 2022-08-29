class Solution {
    public boolean verifyPreorder(int[] preorder) {
        
        int low = Integer.MIN_VALUE;
        
        Stack<Integer> st = new Stack<>();
        
        for(int node : preorder){
            
            if(low > node) return false;
            
            while(!st.isEmpty() && node > st.peek()){
                low = st.pop();
            }
            st.push(node);
        }
        return true;
    }
}