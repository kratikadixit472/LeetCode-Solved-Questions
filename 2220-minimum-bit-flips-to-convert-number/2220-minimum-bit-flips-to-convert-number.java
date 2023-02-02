class Solution {
    public int minBitFlips(int start, int goal) {
        
        int ans = 0;
        int xor = start ^ goal;
        
        while(xor > 0){
            System.out.print(xor +" ");
            ans++;
            xor = xor & (xor - 1);
            
            
        }
        return ans;
    }
}

        