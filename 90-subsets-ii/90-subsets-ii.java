class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        Arrays.sort(nums);
         
        backtrack(0, new ArrayList<>(), nums, ans);
        
        return ans;
    }
    
    private void backtrack(int idx, List<Integer> list, int[] nums, List<List<Integer>> ans){
        
        ans.add(new ArrayList<>(list));
        System.out.println(list);
        
        for(int i = idx ; i < nums.length; i++){
            
            if(i > idx && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            backtrack(i + 1, list, nums, ans);
            list.remove(list.size()-1);
        }
    }
}