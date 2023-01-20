class Solution {
    Set<List<Integer>> ans;
    
    public List<List<Integer>> findSubsequences(int[] nums) {
        
        ans = new HashSet<>();
        backtrack(0, nums, new ArrayList<>());
        return new ArrayList(ans);
    }
    
    private void backtrack(int idx, int[] nums, List<Integer> al){
        if(idx == nums.length){
            if(al.size() >= 2){
                ans.add(new ArrayList<>(al));
            }
            return ;
        }
        
        if(al.size() == 0 || al.get(al.size()-1) <= nums[idx]){
            al.add(nums[idx]);
            backtrack(idx+1, nums, al);
            al.remove(al.size()-1);
        }
        backtrack(idx+1, nums, al);
        
    }
}