class Solution {
    public boolean isHappy(int n) {
        
        Set<Integer> set = new HashSet<>();
        
        while(n != 1 && !set.contains(n)){
            set.add(n);
            n = totalSum(n);
        }
        return n == 1;
    }
    
    private int totalSum(int num){
        
        int sq = 0;
        while(num > 0){
            int r = num % 10;
            num = num / 10;
            sq += r * r;
            
        }
        return sq;
    }
}