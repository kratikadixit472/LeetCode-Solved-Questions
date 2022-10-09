class Solution {
    public int[] amountPainted(int[][] paint) {
        
        int[] line = new int[100005];
        int idx = 0,  n = paint.length;
        
        int[] ans = new int[n];
        
        for(int[] p : paint){
            int start = p[0], end = p[1];
            
            while(start < end){
                
                int jump = Math.max(start+1 ,line[start]);
                if(line[start] == 0) ans[idx]++;
                line[start] = Math.max(end, line[start]);
                
                start = jump;
            }
            idx++;
        }
        return ans;
    }
}