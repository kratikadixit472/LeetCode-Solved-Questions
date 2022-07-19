class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        int n = rooms.size();
        
        boolean[] vis = new boolean[n];
        DFS(0, rooms, vis);
        
        for(boolean v : vis){
            if(!v) return false;
        }
        
        return true;
    }
    
    private void DFS(int src, List<List<Integer>> rooms, boolean[] vis){
        
        vis[src] = true;
        for(int vrtx : rooms.get(src)){
            if(!vis[vrtx]) DFS(vrtx, rooms, vis);
        }
    }
}