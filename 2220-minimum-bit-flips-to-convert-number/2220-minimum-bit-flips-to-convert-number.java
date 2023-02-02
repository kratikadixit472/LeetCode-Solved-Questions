class Solution {
    public int minBitFlips(int start, int goal) {
        
        int ans = 0;
        
        while(start > 0 || goal > 0){
            int tmp1 = start % 2;
            int tmp2 = goal % 2;
            
            if(tmp1 != tmp2) ans++;
            
            start /= 2;
            goal /= 2;
        }
        return ans;
    }
}