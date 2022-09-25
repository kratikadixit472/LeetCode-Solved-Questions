class Solution {
    public int maxArea(int[] A) {
        
        int area = 0, n = A.length;
        
        int l = 0, r = n-1;
        while(l < r){
            area = Math.max(area, Math.min(A[l], A[r]) * (r - l));
            if(A[l] < A[r]){
                l++;
            }
            else r--;
        }
        return area;
    }
}