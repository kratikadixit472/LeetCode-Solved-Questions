class Solution {
    public int numSubmat(int[][] mat) {
        
        int n = mat.length, m = mat[0].length;
        int res = 0;
        int[] h = new int[m];
        
        for(int i = 0; i < n; i++){
            Stack<int[]> st = new Stack<>();
            
            for(int j = 0; j < m; j++){
                int sum = 0;
                h[j] = (mat[i][j] == 0) ? 0 : (h[j] + 1);
                while(!st.isEmpty() && h[st.peek()[0]] >= h[j]) st.pop();
                if(st.isEmpty()) sum = h[j] * (j+1);
                else{
                    sum = h[j] * (j - st.peek()[0]) + st.peek()[1];
                }
                res += sum;
                st.push(new int[]{j, sum});
            }
        }
        return res;
    }
}