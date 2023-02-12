class Solution {
    
    long fuel = 0;
    
    public long minimumFuelCost(int[][] roads, int seats) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int[] road : roads){
            map.putIfAbsent(road[0], new ArrayList<>());
            map.get(road[0]).add(road[1]);
            
            map.putIfAbsent(road[1], new ArrayList<>());
            map.get(road[1]).add(road[0]);
        }
        
        DFS(0, -1, map, seats);
        return fuel;
    }
    
    private int DFS(int node, int par, Map<Integer, List<Integer>> map, int seats) {
        
        int cnt = 1;
        
        if(map.get(node) == null) return cnt;
        
        for(int ngbr : map.get(node)){
            if(ngbr != par){
                cnt += DFS(ngbr, node, map, seats);
            }
        }
        
        if(node != 0){
            fuel += Math.ceil((double)cnt / seats);
        }
        return cnt;
    }
}