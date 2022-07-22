class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        
        int total = 0, n = arr.length;
        
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int sum = 0;
                if((i - j ) % 2 == 0){
                    
                    for(int k = i; k <= j; k++){
                        sum += arr[k];
                    }
                }
                total += sum;
            }
        }
        return total;
    }
}