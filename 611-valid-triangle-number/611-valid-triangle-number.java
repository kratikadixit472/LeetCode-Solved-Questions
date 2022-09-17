class Solution {
    public int triangleNumber(int[] arr) {
        
        Arrays.sort(arr);
        int cnt = 0, n = arr.length;
        for(int i = 0; i < n-2; i++){
            int k = i+2;
            for(int j = i+1; j < n-1 && arr[i] != 0; j++){
                while(k < n && arr[i] + arr[j] > arr[k]) k++;
                cnt += k - j - 1;
            }
        }
        return cnt;
    }
}