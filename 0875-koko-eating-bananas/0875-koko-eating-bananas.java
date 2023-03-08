class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int left = 1, right = 1;
        
        for(int ele : piles){
            right = Math.max(right, ele);
        }
        
        while(left < right){
            
            int mid = (left + right) / 2;
            
            int hour = 0;
            for(int pile : piles){
            
                    int ceil = pile / mid;
                    hour += Math.ceil((double) pile / mid );
                
            }
            
            if(hour <= h){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return right;
    }
}