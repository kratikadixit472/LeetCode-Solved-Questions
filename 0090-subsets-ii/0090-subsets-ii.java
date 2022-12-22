class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        
        backtrack(0, nums, new ArrayList<>(), ans);
        return ans;
    }
    
    private void backtrack(int idx, int[] nums, List<Integer> al, List<List<Integer>> ans){
        ans.add(new ArrayList<>(al));
        // if(idx >= nums.length)return;
        
        for(int i = idx ; i < nums.length; i++){
            if(i != idx && nums[i - 1] == nums[i]) continue;
            al.add(nums[i]);
            backtrack(i+1, nums, al, ans);
            al.remove(al.size()-1);
        }
    }
}