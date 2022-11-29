class Solution {
    public int[] sumZero(int n) {
        
        int[] ans = new int[n];
        int nn = n / 2;
        for(int i = 0; i < n / 2; i++){
            ans[i] = -nn;
            ans[i+n/2] = nn--;
        }
        return ans;
    }
}