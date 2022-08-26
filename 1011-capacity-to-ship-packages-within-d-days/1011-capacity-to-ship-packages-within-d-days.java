class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int left = 0, right = 0;
        
        for(int w : weights) {
            left = Math.max(w, left);
            right += w;
        }
        
        while(left < right){
            
            int need = 1, curr = 0;
            
            int mid = (left + right) / 2;
            
            for(int w : weights){
                if(curr + w > mid){
                    need++;
                    curr = w;
                }
                else curr += w;
            }
            
            if(need > days) left = mid + 1;
            
            else right = mid;
        }
        return left;
    }
}