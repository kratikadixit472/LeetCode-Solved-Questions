class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        subsets(nums, new ArrayList<>(), 0);
        return ans;
    }
    
    private void subsets(int[] nums, ArrayList<Integer> curr, int idx){
        ans.add(new ArrayList<>(curr));
        
        
        for(int i = idx; i < nums.length; i++){
            if(i > idx && nums[i] == nums[i-1]) continue;
            curr.add(nums[i]);
            subsets(nums, curr, i+1);
            curr.remove(curr.size()-1);
        }
    }
}