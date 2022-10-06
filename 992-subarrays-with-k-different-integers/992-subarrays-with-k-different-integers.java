class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        return subArrayWithKDistinct(nums, k) - subArrayWithKDistinct(nums, k-1);
        
    }
    
    private int subArrayWithKDistinct(int[] nums, int k){
        
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0, left = 0;
        
        for(int right = 0; right < nums.length; right++){
            if(map.getOrDefault(nums[right], 0) == 0) k--;
            map.put(nums[right], map.getOrDefault(nums[right], 0)+1);
            
            while(k < 0){
                map.put(nums[left], map.getOrDefault(nums[left], 0)-1);
                if(map.get(nums[left]) == 0) k++;
                left++;
            }
            ans += right - left + 1;
        }
        return ans;
    }
}