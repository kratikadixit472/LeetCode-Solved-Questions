class Solution {
    public int triangleNumber(int[] arr) {
        
        Arrays.sort(arr);
        int cnt = 0, n = arr.length;
        for(int i = 0; i < n-2; i++){
            int k = i+2;
            for(int j = i+1; j < n-1 && arr[i] != 0; j++){
                k = binarySearch(k, arr[i] + arr[j], arr);
                // System.out.println(i+" "+ j +" "+ k);
                cnt += k - j - 1;
            }
        }
        return cnt;
    }
    private int binarySearch(int l, int sum, int[] arr){
        int r = arr.length-1;
        
        while(l <= r){
            int mid = (l + r) / 2;
            if(arr[mid] < sum){
                l = mid + 1;
            }
            else{
                r = mid-1;
            }
        }
        return l;
    }
}