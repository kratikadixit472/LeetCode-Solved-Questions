class Solution {
    public boolean isHappy(int n) {
        
        HashSet<Integer> set = new HashSet<>();
        while(n != 1){
            int sum = 0;
            while(n > 0){
                sum += Math.pow(n%10, 2);
                n = n/10;
            }
            n = sum;
            if(set.contains(sum)) return false;
            set.add(sum);
        }
        return true;
    }
}