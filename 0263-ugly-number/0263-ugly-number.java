class Solution {
    public boolean isUgly(int n) {
        
        if(n <= 0) return false;
        int[] primes = {2, 3, 5};
        
        for(int prime : primes){
            n = keepDividing(n, prime);
        }  
        return (n == 1);
    }
    private int keepDividing(int dividend, int div){
        
        while(dividend % div == 0){
            dividend = dividend / div;
        }
        return dividend;
    }
}