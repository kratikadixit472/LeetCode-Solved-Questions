class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        
        Map<Integer, List<Integer>> childPar = new HashMap<>();
        
        for(int i = 0; i < pid.size(); i++){
            childPar.putIfAbsent(ppid.get(i), new ArrayList<>());
            childPar.get(ppid.get(i)).add(pid.get(i));
        }
        
        List<Integer> ans = new ArrayList<>();
        
        ans.add(kill);
        
        DFS(kill, childPar, ans);
        return ans;
    }
    private void DFS(int par, Map<Integer, List<Integer>> map, List<Integer> ans){
        
        if(map.get(par) != null){
            List<Integer> child = map.get(par);
            
            for(int next : child){
                ans.add(next);
                DFS(next, map, ans);
            }
        }
    }
}