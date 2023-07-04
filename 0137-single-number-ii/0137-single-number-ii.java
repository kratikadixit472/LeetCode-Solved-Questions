class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        
        for(int num : nums){
            if(map.get(num) == 1) return num;
        }
        return -1;
    }
}