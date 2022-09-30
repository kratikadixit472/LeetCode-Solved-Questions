class Solution {
    public int[] amountPainted(int[][] paint) {
        
        int[] line = new int[50001];
        int[] ans = new int[paint.length];
        
        for(int i = 0; i < paint.length; i++){
            int start = paint[i][0], end = paint[i][1];
            while(start < end){
                int jump = Math.max(start+1, line[start]);
                ans[i] += (line[start] == 0) ? 1 : 0;
                
                line[start] = Math.max(end, line[start]);
                start = jump;
            }
        }
        return ans;
    }
}