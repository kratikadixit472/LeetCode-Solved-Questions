class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        
        List<int[]>[] graph = new ArrayList[n];
        
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] m : meetings){
            graph[m[0]].add(new int[]{m[1], m[2]});
            graph[m[1]].add(new int[]{m[0], m[2]});
        }
        
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        boolean[] vis = new boolean[n];
        // ans.add(0);
        q.add(new int[]{firstPerson, 0});
        q.add(new int[]{0, 0});
        
        // vis[firstPerson] = true;
        // vis[0] = true;
        
        while(!q.isEmpty()){
            int[] top = q.poll();
            int curr = top[0], time = top[1];
            if(vis[curr]) continue;
            
            vis[curr] = true;
            
            for(int[] nextMeet : graph[curr]){
                int person = nextMeet[0], t = nextMeet[1];
                if(t < time) continue;
                q.add(new int[]{person, t});
            }
        }
        for(int i = 0  ; i < n; i++){
            if(vis[i]) ans.add(i);
        }
        return ans;
    }
}