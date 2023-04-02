class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        int n = spells.length, m = potions.length;
        Arrays.sort(potions);
        
        int[] res = new int[n];
        int maxPos = potions[m-1];
    
        for(int i=0; i<spells.length; i++){
            
            long pos = (long)Math.ceil(1.0 * success / spells[i]) ;
            
            if(pos > maxPos){
                res[i] = 0;
                continue;
            }
            
            int count = binarySearch((int)pos, potions);
            res[i] = m - count;
        }
        
        return res;
    }
    
    private int binarySearch(int pos, int[] potions){
        
        int l = 0, r = potions.length;
        
        while(l < r){
            int mid = l + (r - l) / 2;
            
            if(potions[mid] < pos){
                l = mid + 1;
            }
            else{
                r = mid;
            }
        }
        return l;
    }
}