class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        
        Arrays.sort(properties, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int n = properties.length, weak = 0;
        
        Stack<int[]> st = new Stack<>();
        
        for(int i = 0; i < properties.length; i++){
            int[] curr = properties[i];
            
            while(!st.isEmpty() && st.peek()[0] < curr[0] && st.peek()[1] < curr[1]){
                st.pop();
                weak++;
            }
            st.push(curr);
        }
        return weak;
    }
}