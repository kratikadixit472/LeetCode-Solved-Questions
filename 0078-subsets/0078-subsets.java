class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        
        backtrack(0, nums, new ArrayList<>(), ans);
        return ans;
    }
    
    private void backtrack(int idx, int[] nums, List<Integer> al, List<List<Integer>> ans){
        ans.add(new ArrayList<>(al));
        
        for(int i = idx ; i < nums.length; i++){
            al.add(nums[i]);
            backtrack(i+1, nums, al, ans);
            al.remove(al.size()-1);
        }
    }
}