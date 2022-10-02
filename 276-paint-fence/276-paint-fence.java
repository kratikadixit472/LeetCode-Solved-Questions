class Solution {
    public int numWays(int n, int k) {
        return findWaysToPaint(n, k);
    }
    private int findWaysToPaint(int n, int k){
        
        if(n == 1) return k;
        if(n == 2) return k * k;
        
        return (k-1) * (findWaysToPaint(n-1, k) + findWaysToPaint(n-2, k));
    }
}