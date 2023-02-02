class Solution {
    public boolean isPowerOfTwo(int N) {
        
        if(N == 0) return false;
        long n = (long)(N);
        return (n & (n - 1)) == 0;
    }
}