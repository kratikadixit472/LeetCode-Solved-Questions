class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int[] mat = new int[m];
        int area = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                mat[j] = (matrix[i][j] == '1') ? mat[j] + 1 : 0;
               
            }
            area = Math.max(area, maxRectangeArea(mat, m));
        }
        
        return area;
    }
    
    private int maxRectangeArea(int[] heights, int n){
        
        int max = 0;
        
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