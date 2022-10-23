class Solution {
    public int[] findErrorNums(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int dup = -1, missing = -1;
        
        for(int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }
        
        for(int ele = 1; ele <= nums.length; ele++){
            if(map.containsKey(ele)){
                if(map.get(ele) == 2){
                    dup = ele;
                }
            }
            else{
                missing = ele;
            }
        }
        
        return new int[]{dup, missing};
    }
}