class Solution {
    int same = 0;
    Map<Integer, List<Integer>> adj;
    
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        adj = new HashMap<>();
        
        for(int[] e : edges){
            adj.putIfAbsent(e[0], new ArrayList<>());
            adj.get(e[0]).add(e[1]);
            adj.putIfAbsent(e[1], new ArrayList<>());
            adj.get(e[1]).add(e[0]);
        }
        int[] ans = new int[n];
        DFS(0, new HashSet<>(), labels, ans);
        return ans; 
            
    }
    
    private int[] DFS(int src, Set<Integer> seen, String labels, int[] ans){
        
        // if(adj.get(src) == null) continue;
        int[] cnt = new int[26];
        if(seen.add(src)){
            
            for(int ngbr: adj.getOrDefault(src, Collections.emptyList())){
                int[] sum = DFS(ngbr, seen, labels, ans);

                for(int i = 0; i < 26; i++){
                    cnt[i] += sum[i];
                }
            }
            cnt[labels.charAt(src) - 'a']++;
            ans[src] = cnt[labels.charAt(src) - 'a'];
        }
        return cnt;
    }
}