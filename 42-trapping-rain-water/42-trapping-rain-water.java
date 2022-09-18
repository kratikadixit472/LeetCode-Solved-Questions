class Solution {
    public int trap(int[] height) {
        
        int n = height.length;
        
        int[] lmin = new int[n];
        int[] rmin = new int[n];
        
        lmin[0] = height[0];
        for(int i = 1; i < n; i++){
            lmin[i] = Math.max(lmin[i-1], height[i]);
        }
        rmin[n-1] = height[n-1];
        for(int i = n-2; i >= 0; i--){
            rmin[i] = Math.max(rmin[i+1],  height[i]);
        }
        
        int water = 0;
        
        for(int i = 0 ;i < n; i++){
            water += Math.min(lmin[i], rmin[i]) - height[i];
        }
        return water;
    }
}