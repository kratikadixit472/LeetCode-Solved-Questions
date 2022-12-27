class Solution {
    public int[] answerQueries(int[] arr, int[] queries) {
        
        Arrays.sort(arr);
        int n = arr.length;
        
        int[] ans = new int[queries.length];
        int[] prefSum = new int[n];
        
        prefSum[0] = arr[0];
        for(int i = 1; i < n; i++){
            prefSum[i] = prefSum[i-1] + arr[i];
        }
        
        int idx = 0;
        
        for(int sum : queries){
            ans[idx++] = binarySearch(prefSum, sum);
        }
        
        return ans;
    }
    
    private int binarySearch(int[] nums, int sum){
        
        int l = 0, r = nums.length-1;
        while(l < r){
            int mid = (r + l) / 2;
            if(nums[mid] == sum) return mid + 1;
            else if(nums[mid] < sum){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        return nums[l] > sum ? l : l + 1;
    }
}