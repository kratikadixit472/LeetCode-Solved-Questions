class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        int n = rooms.size();
        
        boolean[] vis = new boolean[n];
        
        LinkedList<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;
        
        while(!q.isEmpty()){
            int curr = q.poll();
            
            for(int e : rooms.get(curr)){
                if(!vis[e]) {
                    q.add(e);
                    vis[e] = true;
                }
            }
        }
        
        for(boolean v : vis){
            if(!v) return false;
        }
        
        return true;
    }
    
    
}