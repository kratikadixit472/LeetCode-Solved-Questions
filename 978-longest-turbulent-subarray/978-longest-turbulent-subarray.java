class Solution {
    public int maxTurbulenceSize(int[] arr) {
        
        //
        // 1. 
            // 2.
        int ans = 1, n = arr.length, left = 0;
        int prev = 0, flag = 0;
        
        for(int right = 1; right < n; right++){
            
            if(arr[right] == arr[prev]){
                left = right;
                flag = 0;
            }
            
            //increasing
            else if(arr[right] > arr[prev]){
                if(flag == 1) left = right-1;
                flag = 1;
            }
            
            //decreasing
            else if(arr[right] < arr[prev]){
                if(flag == -1) left = right-1;
                flag = -1;
            }
            
            ans = Math.max(ans, right - left + 1);
            prev = right;
            
        }
        return ans;
    }
}

//[37,199,60,296,257,248,115,31,273,176]

