class Solution {
    public int findShortestSubArray(int[] nums) {
        
        int n = nums.length, ans = Integer.MAX_VALUE, degree = 0;
        Map<Integer, Integer> left = new HashMap<>(), right = new HashMap<>(), cnt = new HashMap<>();
        
        for(int i = 0 ; i < n; i++){
            if(!left.containsKey(nums[i])){
                left.put(nums[i], i);
            }
            right.put(nums[i], i);
            cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);
            degree = Math.max(degree, cnt.get(nums[i]));
        }
        
        for(int i = 0 ; i < n; i++){
            if(cnt.get(nums[i]) == degree){
                ans = Math.min(ans, right.get(nums[i]) - left.get(nums[i]) + 1);
            }
        }
        return ans;
    }
}