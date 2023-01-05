class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    
    private int atMost(int[] nums, int k){
        
        int ans = 0, n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int j = 0, i = 0;

        for(j = 0; j < n; j++){
           
            if(map.getOrDefault(nums[j], 0) == 0) k--;
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            
            while(k < 0){
                map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);
                if(map.get(nums[i]) == 0) k++;
                i++;
            }
            ans += (j - i + 1);
        }
        return ans;
    }
}