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
        
        LinkedList<Integer> q = new LinkedList<>();
        q.add(kill);
        
        while(!q.isEmpty()){
            int curr = q.poll();
            ans.add(curr);
            if(adj.get(curr) == null) continue;
            
            for(int ngbr : adj.get(curr)){
                q.add(ngbr);
            }
        }
        return ans;
    }
}