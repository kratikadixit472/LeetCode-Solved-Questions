class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        
        Arrays.sort(properties, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int n = properties.length, weak = 0;
        int maxDef = 0;
        
        Stack<int[]> st = new Stack<>();
        
        for(int i = n-1; i>=0; i--){
            int[] curr = properties[i];
            
            if(curr[1] < maxDef){
                weak++;
            }
            maxDef = Math.max(maxDef, curr[1]);
        }
        return weak;
    }
}