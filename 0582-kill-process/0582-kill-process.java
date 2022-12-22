class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        int n = pid.size();
        
        Map<Integer, List<Integer>> adj = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adj.put(ppid.get(i), new ArrayList<>());
        }
        
        for(int i = 0; i < n; i++){
            adj.get(ppid.get(i)).add(pid.get(i));
        }
        ans.add(kill);
        getAll(kill, adj, ans);
        return ans;
    }
    
    private void getAll(int kill, Map<Integer, List<Integer>> adj, List<Integer> ans) {
        if(adj.get(kill) == null) return ;
        
        for(int ngbr : adj.get(kill)){
            ans.add(ngbr);
            getAll(ngbr, adj, ans);
        }
    }
}