class Solution {
    public int countOdds(int low, int high) {
        int cnt = 0;
        if(low % 2 == 0 && high % 2 == 0) return (high - low) / 2;
        else {
            int ans = ((high - low) / 2) ;
            return ans + 1;
        }

    }
}