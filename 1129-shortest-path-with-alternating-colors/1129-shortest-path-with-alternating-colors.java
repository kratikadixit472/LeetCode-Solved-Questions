class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        
        Map<Integer, List<int[]>> map = new HashMap<>();
        
        for(int[] r : redEdges){
            map.putIfAbsent(r[0], new ArrayList<>());
            map.get(r[0]).add(new int[]{r[1], 0});
        }
        
        for(int[] r : blueEdges){
            map.putIfAbsent(r[0], new ArrayList<>());
            map.get(r[0]).add(new int[]{r[1], 1});
        }
        boolean[][] vis = new boolean[n][2];
        LinkedList<int[]> q = new LinkedList<>();
        
        q.add(new int[]{0, 0, -1});
        vis[0][0] = vis[0][1] = true;
        
        int[] res = new int[n];
        Arrays.fill(res, -1);
        res[0] = 0;
        
        while(!q.isEmpty()){
            int[] top = q.poll();
            
            int node = top[0], steps = top[1], prevC = top[2];
            
            if(!map.containsKey(node)) continue;
            
            for(int[] a : map.get(node)){
                int ngbr = a[0], color = a[1];
                
                if(!vis[ngbr][color] && color != prevC){
                    if(res[ngbr] == -1){
                        res[ngbr] = 1 + steps;
                    }
                    vis[ngbr][color] = true;
                    q.add(new int[]{ngbr, steps + 1, color});
                }
            }
        }
        return res;
    }
}