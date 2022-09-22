class Solution {
    
    private int countPairs(int[] nums, int diff, int n){
        
        int res = 0;
        
        for(int i = 0; i < n; ++i){
            int j = i+1;
            while(j < n && nums[j] - nums[i] <= diff){
                j++;
            }
            res += j - i - 1;
        }
        return res;
    }
    public int smallestDistancePair(int[] nums, int k) {
        
        Arrays.sort(nums);
        
        int n = nums.length;
        int low = nums[1] - nums[0];
        
        for(int  i = 1; i < n-1; i++){
            low = Math.min(low, nums[i+1] - nums[i]);
        }
        int high = nums[n-1] - nums[0];
        
        while(low < high){
            
            int mid = low + (high - low) / 2;
            System.out.println(mid+" "+ low +" "+ high);
            if(countPairs(nums, mid, n) >= k) high = mid;
            
            else{
                low = mid + 1;
            }
            System.out.println(mid+" "+ countPairs(nums, mid, n)+" "+ low +" "+ high);
        }
        return low;
    }
}