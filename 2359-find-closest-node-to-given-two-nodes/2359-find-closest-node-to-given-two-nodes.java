class Solution {
  
    
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        
        int n = edges.length, d = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = node1; i >= 0 && !map.containsKey(i); i = edges[i]){
            map.put(i, d++);
        }
        
        Set<Integer> set = new HashSet<>();
        
        int minDist = Integer.MAX_VALUE, res = -1, dist = 0;
        
        for(int i = node2; i >= 0 && !set.contains(i); i = edges[i]){
            if(map.containsKey(i)){
                
                int curr = Math.max(dist, map.get(i));
                if(res == -1 || minDist >= curr){
                    res = (curr == minDist) ? Math.min(i, res) : i;
                    minDist = curr;
                }
            }
            set.add(i);
            dist++;
        }
        return res;
    }
}
/*
[2,2,3,-1]
0
1
[4,4,4,5,1,2,2]
1
1
[5,4,5,4,3,6,-1]
0
1*/