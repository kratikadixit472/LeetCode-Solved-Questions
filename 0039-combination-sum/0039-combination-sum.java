class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        
        DFS(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }
    
    private void DFS(int idx, int[] cand, int target, List<Integer> al, List<List<Integer>> ans) {
        
        if(idx >= cand.length) return;
        
        if(target == 0){
            ans.add(new ArrayList<>(al));
        }
        
        for(int i = idx; i < cand.length; i++){
            if(target < cand[i]) continue;
            al.add(cand[i]);
            DFS(i, cand, target - cand[i], al, ans);
            al.remove(al.size()-1);
        }
    }
}