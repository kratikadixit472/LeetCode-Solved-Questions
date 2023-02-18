class Solution {
    public String stringShift(String s, int[][] shift) {
        int n = s.length();

        for(int[] sh : shift){
            int amount = sh[1] % n;
            if(sh[0] == 0){
                s = s.substring(amount) + s.substring(0, amount);
            }
            else{
                s = s.substring(n - amount) + s.substring(0, n - amount);
            }
        }
        return s;
    }
}