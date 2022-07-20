class Solution {
    public int[] sumZero(int n) {
        
        int start = 1, left = 0, right = n-1;
        int[] ans = new int[n];
        
        while(left < right){
            ans[left++] = start;
            ans[right--] = -start;
            start++;
        }
        return ans;
    }
}