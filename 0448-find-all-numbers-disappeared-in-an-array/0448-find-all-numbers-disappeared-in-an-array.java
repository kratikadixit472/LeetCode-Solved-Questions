class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(int ele : nums) set.add(ele);
        for(int i = 1; i <= nums.length; i++){
            if(!set.contains(i)) ans.add(i);
        }
        return ans;
    }
}