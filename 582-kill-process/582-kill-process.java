class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        
        Map<Integer, List<Integer>> childPar = new HashMap<>();
        
        for(int i = 0; i < pid.size(); i++){
            childPar.putIfAbsent(ppid.get(i), new ArrayList<>());
            childPar.get(ppid.get(i)).add(pid.get(i));
        }
        
        List<Integer> ans = new ArrayList<>();
        Queue < Integer > q = new LinkedList<>();
        q.add(kill);
        
        while(!q.isEmpty()){
            int par = q.poll();
            ans.add(par);
            
            if(childPar.get(par) != null){
                List<Integer> child = childPar.get(par);

                for(int next : child){
                    q.add(next);
                }
            }
        }
        
        return ans;
    }
}