class Solution {
    public int minScore(int n, int[][] roads) {
        
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        
        for(int[] road : roads){
            map.putIfAbsent(road[0], new ArrayList<>());
            map.get(road[0]).add(Arrays.asList(road[1], road[2]));
            
            map.putIfAbsent(road[1], new ArrayList<>());
            map.get(road[1]).add(Arrays.asList(road[0], road[2]));
        }
        
        boolean[] vis = new boolean[n+1];
        LinkedList<Integer> q = new LinkedList<>();
        q.add(1);
        vis[1] = true;
        
        int ans = Integer.MAX_VALUE;
        
        while(!q.isEmpty()){
            
            int curr = q.poll();
            
            if(!map.containsKey(curr)) continue;
            
            for(List<Integer> al : map.get(curr)){
                ans = Math.min(ans, al.get(1));
                if(!vis[al.get(0)]){
                    vis[al.get(0)] = true;
                    q.add(al.get(0));
                }
            }
        }
        return ans;
    }
}