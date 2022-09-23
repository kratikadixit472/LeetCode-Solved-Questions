class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        int n = routes.length;
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            for(int stop : routes[i]){
                map.putIfAbsent(stop, new HashSet<>());
                map.get(stop).add(i);
            }
        }
        
        Set<Integer> seen = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        boolean[] seen_route = new boolean[n];
        
        q.add(new int[]{source, 0});
        seen.add(source);
        
        while(!q.isEmpty()){
            int[] top = q.poll();
            int stop = top[0], bus = top[1];
            
            if(stop == target) return bus;
            
            for(int i : map.get(stop)){
                
                if(seen_route[i]) continue;
                
                for(int stops : routes[i]){
                    if(!seen.contains(stops)){
                        q.add(new int[]{stops, bus+1});
                        seen.add(stops);
                    }
                }
                seen_route[i] = true;
            }
        }
        return -1;
    }
}