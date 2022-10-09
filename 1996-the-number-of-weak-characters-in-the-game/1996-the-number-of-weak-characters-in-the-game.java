class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        
        int n = properties.length;
        Arrays.sort(properties, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int res = 0, maxDefence = 0;
        
        for(int i = n-1; i >= 0; i--){
            if(properties[i][1] < maxDefence){
                res++;
            }
            maxDefence = Math.max(maxDefence, properties[i][1]);
        }
        return res;
    }
}