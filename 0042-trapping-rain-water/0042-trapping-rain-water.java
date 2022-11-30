class Solution {
    public int trap(int[] height) {
        
        int n = height.length;
        
        int ans = 0, i = 0;
        Stack<Integer> st = new Stack<>();
        
        while(i < n){
            while(!st.isEmpty() && height[i] > height[st.peek()]){
                int top = st.pop();
                if(st.isEmpty()) break;
                
                int wd = i - st.peek() - 1;
                int ht = Math.min(height[i], height[st.peek()]) - height[top];
                
                ans += wd * ht;
            }
            st.push(i++);
        }
        return ans;
    }
}