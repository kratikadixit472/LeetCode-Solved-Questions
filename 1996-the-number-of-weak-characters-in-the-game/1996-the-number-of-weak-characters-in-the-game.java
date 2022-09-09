class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        
        // Stack<int[]> st = new Stack<>();
        int count = 0, maxVal = 0;
        
        for(int i = properties.length-1; i >= 0; i--){
            if(maxVal > properties[i][1]){
                count++;
                // st.pop();
            }
            maxVal = Math.max(maxVal, properties[i][1]);
        }
        return count;
    }
}