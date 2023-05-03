class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        List<Integer> al1 = new ArrayList<>();
        List<Integer> al2 = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        for(int ele : nums1) set1.add(ele);
        for(int ele : nums2) set2.add(ele);
        
        for(int ele : nums1){
            if(!set2.contains(ele)) {
                al1.add(ele);
                set2.add(ele);
            }
        }
        for(int ele : nums2){
            if(!set1.contains(ele)) {
                al2.add(ele);
                set1.add(ele);
            }
        }
        
        ans.add(al1); ans.add(al2);
        return ans;
    }
}