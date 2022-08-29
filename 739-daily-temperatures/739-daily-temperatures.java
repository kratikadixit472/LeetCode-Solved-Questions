class Solution {
    public int[] dailyTemperatures(int[] tmp) {
        
        int n = tmp.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && tmp[st.peek()] < tmp[i]){
                ans[st.peek()] = i - st.peek();
                st.pop();
            }
            st.push(i);
        }
        return ans;
    }
}