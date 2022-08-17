class Solution {
    public int openLock(String[] deadends, String target) {
        
        Set<String> set = new HashSet<>();
        for(String ele : deadends){
            set.add(ele);
        }
        
        String start = "0000";
        
        LinkedList<String> q = new LinkedList<>();
        q.add(start);
        if(set.contains(start)) return -1;
        
        int turns = 0;
        
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                String curr = q.poll();
                if(curr.equals(target)) return turns;
                List<String> ngbr = findPossible(curr, set);
                for(String ns : ngbr){
                  //  if(set.contains(ns)) continue;
                    set.add(ns);
                    q.add(ns);
                }
            }
            turns++;
        }
        return -1;
    }
    
    private List<String> findPossible(String s, Set<String> set){
        
        List<String> res = new ArrayList<>();
        
        for(int i = 0; i < 4; i++){
            int curr = s.charAt(i) -'0';
            for(int diff = -1; diff <= 1; diff += 2){
                int next = (curr + diff + 10) % 10;
                String ngbr = s.substring(0, i) + (""+ next) + s.substring(i+1);
                if(!set.contains(ngbr)) res.add(ngbr);
            }
        }
        return res;
    }
}