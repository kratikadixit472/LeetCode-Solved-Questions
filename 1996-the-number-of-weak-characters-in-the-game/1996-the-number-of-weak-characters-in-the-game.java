class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        
        Stack<int[]> st = new Stack<>();
        int count = 0;
        
        for(int[] prop : properties){
            while(!st.isEmpty() && st.peek()[1] < prop[1]){
                count++;
                st.pop();
            }
            st.push(prop);
        }
        return count;
    }
}