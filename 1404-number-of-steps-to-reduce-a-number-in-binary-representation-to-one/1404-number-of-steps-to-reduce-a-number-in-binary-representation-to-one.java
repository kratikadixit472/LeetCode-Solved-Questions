class Solution {
    public int numSteps(String s) {
        
        int sl = s.length();
        int ans = 0, carry = 0;
        
        for(int i = sl - 1; i >= 1; i--){
            if(s.charAt(i) - '0' + carry == 1){
                carry = 1;
                ans += 2;
            }
            else{
                ans++;
            }
        }
        return ans + carry ;
    }
}