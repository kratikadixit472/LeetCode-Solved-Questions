class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        
        DFS(0, nums, new ArrayList<>(), ans, new boolean[nums.length]);
        return ans;
    }
    
    private void DFS(int idx, int[] nums, List<Integer> al, List<List<Integer>> ans, boolean[] used) {
        
        if(idx > nums.length) return;
        
        if(al.size() == nums.length){
            ans.add(new ArrayList<>(al));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;
            used[i] = true;
            al.add(nums[i]);
            DFS(i+1, nums, al, ans, used);
            used[i] = false;
            al.remove(al.size()-1);
        }
    }
}