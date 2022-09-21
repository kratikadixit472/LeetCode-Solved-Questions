class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        
        List<Integer>[] graph = new ArrayList[n+1];
        
        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        int[] indegree = new int[n+1];
        
        for(int[] rel : relations){
            graph[rel[0]].add(rel[1]);
            indegree[rel[1]]++;
        }
        
        LinkedList<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            if(indegree[i] == 0) q.add(i);
        }
        
        int minSem = 0;
        
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                int top = q.poll();

                for(int next : graph[top]){
                    indegree[next]--;
                    if(indegree[next] == 0)q.add(next);
                }
            }
            minSem++;
        }
        for(int in : indegree) if(in != 0) return -1;
        return minSem ;
    }
}