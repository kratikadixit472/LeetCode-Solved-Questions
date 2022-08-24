class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int n = heights.length;
        
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        
        for(int i = 0; i < n ; i++){
            while(st.peek() != -1 && heights[st.peek()] >= heights[i]){
                int h = heights[st.pop()];
                int w = i - st.peek() - 1;
                // System.out.println(h + " "+ w +" "+ h*w +" ");
                max = Math.max(max, h * w);
            }
            st.push(i);
        }
        
        while(st.size() > 1){
            int h = heights[st.pop()];
            int w = n - st.peek() - 1;
            // System.out.println(h + " "+ w +" "+ h*w +" ");
            max = Math.max(max, h * w);
        }
        
        return max;
    }
}