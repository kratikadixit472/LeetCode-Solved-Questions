class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        List<Integer> al = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int ele : nums1){
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        
        for(int ele : nums2){
            if(map.containsKey(ele) && map.get(ele) > 0){
                al.add(ele);
                map.put(ele, map.getOrDefault(ele, 0) - 1);
            }
        }
        
        int[] ans = new int[al.size()];
        int idx = 0;
        
        for(int ele : al){
            ans[idx++] = ele;
        }
        return ans;
    }
}