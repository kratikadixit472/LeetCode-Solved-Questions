class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, 0, target, new ArrayList<>());
        return ans;
    }
    
    private void backtrack(int[] nums, int idx, int target, List<Integer> al){
        if(target == 0){
            ans.add(new ArrayList<>(al));
            return;
        }
        
        for(int i = idx; i < nums.length; i++){
            if(target - nums[i] >= 0){
                al.add(nums[i]);
                backtrack(nums, i, target - nums[i], al);
                al.remove(al.size()-1);
            } 
        }
    }
}