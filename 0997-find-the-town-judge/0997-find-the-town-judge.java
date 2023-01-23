class Solution {
    public int findJudge(int n, int[][] trust) {
        
        int[] judge = new int[n+1];
        
        for(int[] t : trust){
            judge[t[0]]--;
            judge[t[1]]++;
        }
        for(int i = 1; i < judge.length; i++){
            if(judge[i] == n-1){
                return i;
            }
        }
        return -1;
    }
}