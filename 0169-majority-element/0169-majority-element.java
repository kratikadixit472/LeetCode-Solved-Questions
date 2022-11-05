class Solution {
    public int majorityElement(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0, n = nums.length;
        
        for(int ele : nums){
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        
        for(int key : map.keySet()){
            if(map.get(key) > n / 2) ans = key;
        }
        return ans;
        
    }
}