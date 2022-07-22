class Solution {
    public int minSwaps(int[] data) {
        
        int onces = 0, n = data.length;
        int max = Integer.MIN_VALUE;
        
        for(int ele : data) if(ele == 1) onces += 1;
        
        int left = 0, right = 0, one = 0;
        
        while(right < n){
            
            while(right < n && right - left < onces){
                if(data[right++] == 1) one++;
            }
            
            max = Math.max(max, one);
            
            if(right == n) break;
            
            one -= data[left++];
        }
        
        return onces - max;
    }
}