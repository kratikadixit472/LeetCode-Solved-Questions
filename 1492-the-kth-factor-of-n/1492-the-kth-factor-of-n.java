class Solution {
    public int kthFactor(int n, int k) {
        int i = 1;
        
        while(i <= n && k >= 0){
            if(n % i == 0) k--;
            if(k == 0) return i;
            i++;
        }
        return -1;
    }
}