class Solution {
    public boolean isHappy(int n) {
        
        Set<Integer> set = new HashSet<>();
        while(n != 0 && !set.contains(n)){
            set.add(n);
            n = getNext(n);
        }
        
        return (n == 1);
    }
    
    private int getNext(int n){
        
        int num = n, sum = 0;
        while(num > 0){
            int curr = num % 10;
            sum += curr * curr;
            num = num / 10;
        }
        return sum;
    }
}