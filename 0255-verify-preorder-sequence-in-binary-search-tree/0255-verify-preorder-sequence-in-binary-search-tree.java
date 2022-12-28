class Solution {
    public boolean verifyPreorder(int[] preorder) {
        
        Stack<Integer> st = new Stack<>();
        int lower = Integer.MIN_VALUE;
        
        int n = preorder.length;
        for(int i = 0; i < n; i++){
            if(st.isEmpty() || preorder[i] < preorder[i-1]){
                if(lower >= preorder[i]) return false;
                st.add(preorder[i]);
            }
            else{
                while(!st.isEmpty() && st.peek() < preorder[i]){
                    lower = st.pop();
                }
                st.add(preorder[i]);
            }
        }
        return true;
    }
}